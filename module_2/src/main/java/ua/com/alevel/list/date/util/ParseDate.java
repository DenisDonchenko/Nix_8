package ua.com.alevel.list.date.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class ParseDate {
    private ParseDate() {
    }

    private static String delimiter = "";

    public static List<String> parse(String dateString) {
        delimiter = isDelimiter(dateString);
        return dateString.lines()
                .flatMap(line -> Arrays.stream(line.split(delimiter)))
                .collect(Collectors.toList());
    }

    public static String convertToDateString(String dateInfo) {
        List<String> dateInfoToList = parse(dateInfo);
        if (dateInfoToList.get(0).length() == 4) {
            return dateInfoToList.get(0) + dateInfoToList.get(1) + dateInfoToList.get(2);
        } else {
            return dateInfoToList.get(2) + dateInfoToList.get(1) + dateInfoToList.get(0);
        }
    }

    private static String isDelimiter(String dateTimeFormat) {
        if (dateTimeFormat.contains("/")) {
            return "/";
        } else return "-";
    }
}
