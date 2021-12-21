package ua.com.alevel.unique.name;

import ua.com.alevel.util.ConstGlobal;
import ua.com.alevel.util.FileHelper;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class UniqueNames {
    private List<String> strings = new ArrayList<>();
    private String uniqueName = "";

    public void run() {
        FileHelper.createFolders(ConstGlobal.FOLDERS_UNIQUE_NAME);
        FileHelper.createFile(ConstGlobal.PATH_TO_FILE_UNIQUE_NAME_INPUT, ConstGlobal.PATH_TO_FILE_UNIQUE_NAME_OUTPUT);

        readNames();
        if (strings.isEmpty()) {
            FileHelper.writerTextToFile(ConstGlobal.PATH_TO_FILE_UNIQUE_NAME_OUTPUT, "File is empty");
        } else {
            searchUniqueName();
            FileHelper.writerTextToFile(ConstGlobal.PATH_TO_FILE_UNIQUE_NAME_OUTPUT, uniqueName);
        }
    }

    private void searchUniqueName() {
        try {
            uniqueName = strings.stream()
                    .filter(person -> Collections.frequency(strings, person) == 1)
                    .collect(Collectors.toList()).get(0);
        } catch (IndexOutOfBoundsException er) {
            uniqueName = "File does not contain unique names";
        }
    }

    private void readNames() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(ConstGlobal.PATH_TO_FILE_UNIQUE_NAME_INPUT));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        strings = reader.lines()
                .flatMap(line -> Arrays.stream(line.split("[-.?!)(,:/ ]")))
                .collect(Collectors.toList());

    }
}
