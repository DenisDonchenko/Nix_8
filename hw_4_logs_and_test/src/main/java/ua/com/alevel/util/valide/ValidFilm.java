package ua.com.alevel.util.valide;

import ua.com.alevel.exception.film.InvalidFilmException;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public final class ValidFilm {
    private static final String REGEX_NAME = "^[a-zA-Z0-9]{1,100}$";
    private static final String REGEX_YEARS = "[0-9]{4}";
    private static ResourceBundle settings = ResourceBundle.getBundle("message", Locale.ENGLISH);

    private ValidFilm() {
    }

    public static void validName(String name) {
        if (name.isEmpty()) {
            throw new InvalidFilmException(settings.getString("film.name.empty"));
        }
        if (!Pattern.matches(REGEX_NAME, name)) {
            throw new InvalidFilmException(settings.getString("film.name.format"));
        }
        if (name.length() < 1 || name.length() > 100) {
            throw new InvalidFilmException(settings.getString("film.name.length.format"));
        }
    }

    public static void validYear(String year) {
        if (year.isEmpty()) {
            throw new InvalidFilmException(settings.getString("film.year.empty"));
        }
        if (!Pattern.matches(REGEX_YEARS, year)) {
            throw new InvalidFilmException(settings.getString("film.year.format"));
        }
        if (year.length() != 4) {
            throw new InvalidFilmException(settings.getString("film.year.length.format"));
        }
    }

}
