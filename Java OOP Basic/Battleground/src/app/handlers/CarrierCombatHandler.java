package app.handlers;

import app.factories.SpellFactory;
import app.interfaces.gameLogic.CombatHandler;
import app.interfaces.gameModels.Spell;

public class CarrierCombatHandler extends CombatHandlerImpl implements CombatHandler {


    @Override
    public final Spell generateAttack() {
        Spell unitSpell = SpellFactory.createBulletRain();
        if (super.getUnit().getEnergyPoints()<unitSpell.getEnergyCost()){
            return null;
        }
        super.getUnit().setEnergyPoints(super.getUnit().getEnergyPoints()-unitSpell.getEnergyCost());
        return unitSpell;
    }
}
