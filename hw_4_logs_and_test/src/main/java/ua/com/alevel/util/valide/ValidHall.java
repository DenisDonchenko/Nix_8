package ua.com.alevel.util.valide;

import ua.com.alevel.exception.film.InvalidFilmException;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class ValidHall {

    private static final String REGEX_NAME = "^[a-zA-Z0-9]{1,100}$";
    private static final String REGEX_CAPACITY = "^[0-9]+$";
    private static ResourceBundle settings = ResourceBundle.getBundle("message", Locale.ENGLISH);

    private ValidHall() {
    }

    public static void validName(String name) {
        if (name.isEmpty()) {
            throw new InvalidFilmException(settings.getString("hall.name.empty"));
        }
        if (!Pattern.matches(REGEX_NAME, name)) {
            throw new InvalidFilmException(settings.getString("hall.name.format"));
        }
        if (name.length() < 1 || name.length() > 100) {
            throw new InvalidFilmException(settings.getString("hall.name.length.format"));
        }
    }

    public static void validCapacity(String capacity) {
        if (capacity.isEmpty()) {
            throw new InvalidFilmException(settings.getString("hall.capacity.empty"));
        }
        if (!Pattern.matches(REGEX_NAME, capacity)) {
            throw new InvalidFilmException(settings.getString("hall.capacity.format"));
        }
    }

}
