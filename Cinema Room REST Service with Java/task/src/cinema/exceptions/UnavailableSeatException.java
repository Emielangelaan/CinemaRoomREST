package cinema.exceptions;

public class UnavailableSeatException extends RuntimeException {
    public UnavailableSeatException(String message) {
        super(message);
    }
    public UnavailableSeatException() {
        super();
    }
}
