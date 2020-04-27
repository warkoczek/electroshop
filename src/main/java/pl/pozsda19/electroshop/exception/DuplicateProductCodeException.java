package pl.pozsda19.electroshop.exception;

public class DuplicateProductCodeException extends RuntimeException {

    public DuplicateProductCodeException(String message) {
        super(message);
    }
}
