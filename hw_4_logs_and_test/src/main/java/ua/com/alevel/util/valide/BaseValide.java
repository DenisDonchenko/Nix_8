package ua.com.alevel.util.valide;

import ua.com.alevel.util.ConstGlobal;

import java.util.regex.Pattern;

public abstract class BaseValide {

    static final String REGEX_DATE = "(0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).((19|20)\\d\\d)";
    static final String REGEX_YEARS = "[0-9]{4}";
    static final String REGEX_TIME = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
    static final String REGEX_ID = "\\d+";
    static final String REGEX_CAPACITY = "\\d+";

    public static boolean validName(String name, String messageEmpty) {

        if (name.isEmpty()) {
            System.out.println(ConstGlobal.settings.getString(messageEmpty));
            return false;
        }
        return true;
    }

    public static boolean validIdEntity(String id) {
        if (id.isEmpty()) {
            System.out.println(ConstGlobal.settings.getString("id.empty"));
            return false;
        }
        if (!Pattern.matches(REGEX_ID, id)) {
            System.out.println(ConstGlobal.settings.getString("id.format"));
            return false;
        }
        return true;
    }

    public static boolean validTime(String time, String messageEmpty, String messageFormat) {
        if (time.isEmpty()) {
            System.out.println(ConstGlobal.settings.getString(messageEmpty));
            return false;
        }
        if (!Pattern.matches(REGEX_TIME, time)) {
            System.out.println(ConstGlobal.settings.getString(messageFormat));
            return false;
        }
        return true;
    }
}
