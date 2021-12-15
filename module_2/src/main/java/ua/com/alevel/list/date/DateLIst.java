package ua.com.alevel.list.date;

import ua.com.alevel.list.date.util.ParseDate;
import ua.com.alevel.list.date.util.ValidationDate;
import ua.com.alevel.util.ConstGlobal;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DateLIst {
    private List<String> datesList = new ArrayList<>();

    public void run() {
        readNames();
        writeDateToFile();
    }

    private void readNames() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(ConstGlobal.PATH_TO_FILE_LIST_DATES_INPUT));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        datesList = reader.lines()
                .flatMap(line -> Arrays.stream(line.split("[.?!)(,: ]")))
                .collect(Collectors.toList())
                .stream().filter(DateLIst::validDate).collect(Collectors.toList());
        if (datesList.isEmpty()) {
            writerDate("The file does not contain dates of the following formats \nyyyy-MM-dd\nyyyy/MM/dd\ndd-MM-yyyy\ndd/MM/yyyy \nor  file is empty");
            System.exit(0);
        }
    }

    private void writerDate(String text) {
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(ConstGlobal.PATH_TO_FILE_LIST_DATES_OUTPUT))) {
            writter.write(text + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeDateToFile() {
        datesList = datesList.stream().map(ParseDate::convertToDateString).collect(Collectors.toList());
        writerDate(datesList.toString());
    }

    private static boolean validDate(String date) {
        return ValidationDate.validDate(date);
    }
}
