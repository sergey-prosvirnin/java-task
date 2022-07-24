package cz.acamar.tasks.exception;

public class NotValidStringException extends IllegalArgumentException {
    public NotValidStringException(String s) {
        super(s);
    }
}
