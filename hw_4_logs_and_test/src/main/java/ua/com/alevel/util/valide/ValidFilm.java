package ua.com.alevel.util.valide;

import ua.com.alevel.util.ConstGlobal;

import java.util.regex.Pattern;

public final class ValidFilm extends BaseValide {

    private ValidFilm() {
    }

    public static boolean validYear(String year) {
        if (year.isEmpty()) {
            System.out.println(ConstGlobal.settings.getString("film.year.empty"));
            return false;
        }
        if (!Pattern.matches(REGEX_YEARS, year)) {
            System.out.println(ConstGlobal.settings.getString("film.year.format"));
            return false;
        }
        if (year.length() != 4) {
            System.out.println(ConstGlobal.settings.getString("film.year.length.format"));
            return false;
        }
        return true;
    }
}
