package p05_online_radio_database.exceptions;

public class InvalidSongException extends Throwable {
    public InvalidSongException(String message) {
        super(message);
    }
}
