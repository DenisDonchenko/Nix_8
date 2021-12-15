package ua.com.alevel.list.date.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public final class ValidationDate {

    private ValidationDate() {
    }

    private static boolean isLeapYear;

    private static final List<String> REGEX_DATE_LIST = Arrays.asList(
            "^\\d{4}[\\/\\-](0?[1-9]|1[012])[\\/\\-](0?[1-9]|[12][0-9]|3[01])$",
            "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$");

    private static List<String> dateInfo = new ArrayList<>();

    public static boolean validDate(String dateString) {
        if (!Pattern.matches(REGEX_DATE_LIST.get(0), dateString) && !Pattern.matches(REGEX_DATE_LIST.get(1), dateString)) {
            System.out.println(REGEX_DATE_LIST.get(0));
            return false;
        }
        if (Pattern.matches(REGEX_DATE_LIST.get(0), dateString)) {
            readDate(dateString, 0);
            int lengthMonth = lengthMonth(Integer.parseInt(dateInfo.get(1)));
            if (Integer.parseInt(dateInfo.get(2)) > lengthMonth) {
                return false;
            }
        }
        if (Pattern.matches(REGEX_DATE_LIST.get(1), dateString)) {
            readDate(dateString, 2);
            int lengthMonth = lengthMonth(Integer.parseInt(dateInfo.get(1)));
            if (Integer.parseInt(dateInfo.get(0)) > lengthMonth) {
                return false;
            }
        }
        return true;
    }

    private static void readDate(String dateString, int indexYear) {
        dateInfo = ParseDate.parse(dateString);
        isLeapYear = isLeapYear(Integer.parseInt(dateInfo.get(indexYear)));
    }

    private static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    private static int lengthMonth(int month) {
        switch (month) {
            case 2 -> {
                return isLeapYear ? 29 : 28;
            }
            case 4, 6, 9, 11 -> {
                return 30;
            }
            default -> {
                return 31;
            }
        }
    }
}
