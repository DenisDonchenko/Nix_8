package ua.com.alevel.util;

import java.util.Locale;
import java.util.ResourceBundle;

public final class ConstGlobal {
    private ConstGlobal() {
    }

    public static ResourceBundle settingsFile = ResourceBundle.getBundle("path", Locale.ENGLISH);

    public static final String FOLDERS_LIST_DATES = settingsFile.getString("path.list.dates.input");
    public static final String PATH_TO_FILE_LIST_DATES_INPUT = FOLDERS_LIST_DATES + settingsFile.getString("name.file.list.dates.input");
    public static final String PATH_TO_FILE_LIST_DATES_OUTPUT = FOLDERS_LIST_DATES + settingsFile.getString("name.file.list.dates.output");

    public static final String FOLDERS_UNIQUE_NAME = settingsFile.getString("path.unique.name.input");
    public static final String PATH_TO_FILE_UNIQUE_NAME_INPUT = FOLDERS_UNIQUE_NAME + settingsFile.getString("name.file.unique.name.input");
    public static final String PATH_TO_FILE_UNIQUE_NAME_OUTPUT = FOLDERS_UNIQUE_NAME + settingsFile.getString("name.file.unique.name.output");
}
