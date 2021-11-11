package ua.com.alevel.exception.hall;

public class HallNotFoundException extends RuntimeException {
    public HallNotFoundException() {
        super();
    }

    public HallNotFoundException(String message) {
        super(message);
    }

    public HallNotFoundException(String message, Throwable cause) {
        super(message, cause);

    }
}
