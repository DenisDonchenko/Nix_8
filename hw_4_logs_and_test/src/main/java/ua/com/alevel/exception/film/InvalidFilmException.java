package ua.com.alevel.exception.film;

public class InvalidFilmException extends RuntimeException{
    public InvalidFilmException() {
    }

    public InvalidFilmException(String message) {
        super(message);
    }

    public InvalidFilmException(String message, Throwable cause) {
        super(message, cause);
    }
}
