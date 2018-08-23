package implementation;

public abstract class CharacterImpl {
    private String userName;
    private String characterType;
    private int level;

    protected CharacterImpl(String userName, String characterType, int level) {
        this.setUserName(userName);
        this.characterType = characterType;
        this.level = level;
    }

    public void setUserName(String userName) {
        if (!userName.matches("\"[A-Za-z]{1,10}\"")){
            throw new IllegalArgumentException();
        }
        this.userName = userName;
    }

    protected String getUserName() {
        return this.userName;
    }

    protected String getCharacterType() {
        return this.characterType;
    }

    protected int getLevel() {
        return this.level;
    }
}
