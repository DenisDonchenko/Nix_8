package ua.com.alevel.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public final class ConstGlobal {

    public static final ResourceBundle settings = ResourceBundle.getBundle("message", Locale.ENGLISH);
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static Logger loggerInfo = LoggerFactory.getLogger("info");
    public static Logger loggerWarn = LoggerFactory.getLogger("warn");
}
