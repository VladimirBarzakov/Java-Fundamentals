package implementation;

import interfaces.Character;

public class DemonImpl extends CharacterImpl implements Character {
    private long hashedPassword;
    private double specialPoints;

    protected DemonImpl(String userName, String characterType, double specialPoints, int level) {
        super(userName, characterType, level);
        this.specialPoints=specialPoints;
        this.setHashedPassword();
    }

    private void setHashedPassword() {
        this.hashedPassword=super.getUserName().length()*217;
    }

    @Override
    public String toString() {
        return String.format("\"%s\" | \"%d\" -> %s\n" +
                        "%.1f", super.getUserName(),
                this.hashedPassword, super.getCharacterType(),
                this.specialPoints * super.getLevel());
    }
}
