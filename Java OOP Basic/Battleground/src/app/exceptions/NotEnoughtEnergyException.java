package app.exceptions;

public class NotEnoughtEnergyException extends InvalidUnitException {
    public NotEnoughtEnergyException(String message) {
        super(message);
    }
}
