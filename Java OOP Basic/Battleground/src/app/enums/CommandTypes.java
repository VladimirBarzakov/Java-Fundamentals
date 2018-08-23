package app.enums;

public enum CommandTypes {
    SPAWN,
    STATUS,
    MOVE,
    FIGHT,
    GAME_OVER;

    @Override
    public String toString() {
        return this.name().replaceAll("_", "-").toLowerCase();
    }
}
