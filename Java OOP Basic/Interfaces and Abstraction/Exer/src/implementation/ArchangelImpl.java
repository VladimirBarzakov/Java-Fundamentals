package implementation;

import interfaces.Character;

public class ArchangelImpl extends CharacterImpl implements Character {
    private String hashedPassword;
    private int specialPoints;


    protected ArchangelImpl(String userName, String characterType, int specialPoints, int level) {
        super(userName, characterType, level);
        this.setHashedPassword();
        this.specialPoints=specialPoints;
    }

    private void setHashedPassword() {
        StringBuilder temp = new StringBuilder();
        for (int i = super.getUserName().length()-1; i >=0 ; i--) {
            temp.append(String.valueOf(super.getUserName().charAt(i)));
        }
        this.hashedPassword = String.format("%s%d",temp.toString(),super.getUserName().length()*21);
    }

    @Override
    public String toString() {
        return String.format("\"%s\" | \"%s\" -> %s\n" +
                        "%d", super.getUserName(),
                this.hashedPassword, super.getCharacterType(),
                this.specialPoints * super.getLevel());
    }
}
