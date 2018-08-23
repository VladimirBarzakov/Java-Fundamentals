package app.commands;

import app.constants.GameMessages;
import app.exceptions.IllegalPositionException;
import app.exceptions.InvalidUnitException;
import app.interfaces.gameLogic.Command;
import app.interfaces.gameModels.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FightCommand extends BaseCommand implements Command {
    public FightCommand(Battleground battleground,
                        ActiveRepository<Unit> activeUnitRepository,
                        InactiveRepository<Unit> killedUnitRepository) {
        super(battleground, activeUnitRepository, killedUnitRepository);
    }

    @Override
    public String execute(String[] args) {
        List<Unit> activeUnits = super.getActiveRepository().findAll();
        if (activeUnits.size() < 2) {
            return GameMessages.NOT_ENOUGH_UNITS_FOR_FIGHTING_MESSAGE;
        }
        Map<String, Long> damageReceivedByUnit = new HashMap<>();
        Map<String, List<String>> attackersGroupByTarget = new HashMap<>();
        StringBuilder builder = new StringBuilder();

        //Calculate damage independently for every unit on the Battleground
        for (Unit unit : activeUnits) {
            builder.append(System.lineSeparator());
            Position unitPosition = unit.getPosition();
            int unitRange = unit.getRange();
            List<Unit> potentialTargets = super.getBattleground().getUnitsInRange(unitPosition, unitRange);
            if (potentialTargets.size() == 0) {
                builder.append(String.format(GameMessages.NO_TARGETS_IN_FIGHTING_RANGE_MESSAGE, unit.getName()));
                continue;
            }
            Unit target = unit.getCombatHandler().pickNextTarget(potentialTargets);
            Spell unitSpell = unit.getCombatHandler().generateAttack();
            if (unitSpell != null) {
                long damage = Math.round((unit.getAttackPoints() / (double) target.getDefencePoints()) * unitSpell.getDamage());
                damageReceivedByUnit.putIfAbsent(target.getName(), 0L);
                attackersGroupByTarget.putIfAbsent(target.getName(), new ArrayList<>());
                damageReceivedByUnit.put(target.getName(), damageReceivedByUnit.get(target.getName()) + damage);
                attackersGroupByTarget.get(target.getName()).add(unit.getName());
                builder.append(String.format(GameMessages.SUCCESSFUL_FIGHT_COMMAND_MESSAGE,
                        unit.getName(),
                        unitSpell.getClass().getSimpleName(),
                        unitSpell.getDamage()));
            } else {
                builder.append(String.format(GameMessages.NOT_EGOIST_ENERGY_POINTS_TO_CAST_SPELL_MESSAGE, unit.getName(), unitSpell.getClass().getSimpleName()));
            }
        }

        //Receive damage for every unit and remove from Battleground if necessary
        for (Map.Entry<String, Long> unitAndDamageTaken : damageReceivedByUnit.entrySet()) {
            try {
                Unit unit = super.getActiveRepository().getEntity(unitAndDamageTaken.getKey());
                if ((long) unit.getHealthPoints() <= unitAndDamageTaken.getValue()) {
                    unit.setHealthPoints(0);
                    super.getBattleground().remove(unit);
                    super.getKilledRepository().save(unit);
                    super.getActiveRepository().remove(unit);
                    builder.append(System.lineSeparator());
                    builder.append(String.format(
                            GameMessages.UNIT_GET_KILLED_MESSAGE, unit.getName(),
                            attackersGroupByTarget.get(unit.getName().replaceAll("[\\[\\]]", ""))));
                } else {
                    unit.setHealthPoints((int) (unit.getHealthPoints() - unitAndDamageTaken.getValue()));
                }
            } catch (InvalidUnitException | IllegalPositionException e) {
                e.printStackTrace();
            }
        }

        return builder.toString().trim();
    }
}
