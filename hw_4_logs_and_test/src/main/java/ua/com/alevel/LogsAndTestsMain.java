package ua.com.alevel;
import ua.com.alevel.controller.FilmController;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LogsAndTestsMain {
    public static void main(String[] args) {
        new FilmController().run();
    }
}
