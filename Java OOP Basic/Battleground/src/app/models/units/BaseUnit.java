package app.models.units;

import app.interfaces.gameLogic.CombatHandler;
import app.interfaces.gameModels.Position;
import app.interfaces.gameModels.Unit;

public abstract class BaseUnit implements Unit {
    private String name;
    private Integer range;
    private Position position;
    private int healthPoints;
    private int energyPoints;
    private int attackPoints;
    private int defencePoints;
    private CombatHandler combatHandler;

    protected BaseUnit(
            String name,
            int range,
            Position position,
            int healthPoints,
            int energyPoints,
            int attackPoints,
            int defencePoints,
            CombatHandler combatHandler) {
        this.name = name;
        this.position = position;
        this.range = range;
        this.healthPoints = healthPoints;
        this.energyPoints = energyPoints;
        this.attackPoints = attackPoints;
        this.defencePoints = defencePoints;
        this.combatHandler = combatHandler;
        this.combatHandler.setUnit(this);
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getRange() {
        return this.range;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(Position position) {
        this.position=position;
    }

    @Override
    public int getHealthPoints() {
        return this.healthPoints;
    }

    @Override
    public void setHealthPoints(int healthPoints) {
        this.healthPoints=healthPoints;
    }

    @Override
    public int getEnergyPoints() {
        return this.energyPoints;
    }

    @Override
    public void setEnergyPoints(int energyPoints) {
        this.energyPoints=energyPoints;
    }

    @Override
    public int getAttackPoints() {
        return this.attackPoints;
    }


    @Override
    public int getDefencePoints() {
        return this.defencePoints;
    }

    @Override
    public CombatHandler getCombatHandler() {
        return this.combatHandler;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("- Attack Points: ").append(this.attackPoints).
                append(System.lineSeparator());
        builder.append("- Defence Points: ").append(this.defencePoints).
                append(System.lineSeparator());
        builder.append("- Energy Points: ").append(this.energyPoints).
                append(System.lineSeparator());
        builder.append("- Health Points: ").append(this.healthPoints);
        return builder.toString().trim();
    }
}
