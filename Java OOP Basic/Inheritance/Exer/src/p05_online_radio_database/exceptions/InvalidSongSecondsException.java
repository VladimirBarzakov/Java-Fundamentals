package p05_online_radio_database.exceptions;

public class InvalidSongSecondsException extends InvalidSongLengthException {
    public InvalidSongSecondsException(String s) {
        super(s);
    }
}
