package app.exceptions;

public class UnknownUnitTypeException extends InvalidUnitException {
    public UnknownUnitTypeException(String message) {
        super(message);
    }
}
