package ua.com.alevel.exception.film;

public class FilmNotFoundException extends RuntimeException {
    public FilmNotFoundException() {
        super();
    }

    public FilmNotFoundException(String message) {
        super(message);
    }

    public FilmNotFoundException(String message, Throwable cause) {
        super(message, cause);

    }
}
