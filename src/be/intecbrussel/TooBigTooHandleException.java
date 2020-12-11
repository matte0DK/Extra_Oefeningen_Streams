package be.intecbrussel;

public class TooBigTooHandleException extends Exception {
    public TooBigTooHandleException() {
    }

    public TooBigTooHandleException(String message) {
        super(message);
    }

    public TooBigTooHandleException(String message, Throwable cause) {
        super(message, cause);
    }

    public TooBigTooHandleException(Throwable cause) {
        super(cause);
    }
}
