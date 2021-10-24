package ua.com.alevel.takesAndSortingChar;

import ua.com.alevel.ProgramRun;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class TakesAndSortingCharWithString {

    private char[] charArray;
    private String inputString = null;
    private HashMap<Character, Integer> characters = new HashMap<>();
    private BufferedReader reader;

    public TakesAndSortingCharWithString(BufferedReader reader) {
        this.reader = reader;
    }

    public void run() throws IOException {
        readString();
    }

    private void countCharacter() {
        for (int i = 0; i < charArray.length; i++) {
            int occurrencesCount = count(charArray[i]);
            characters.put(charArray[i], occurrencesCount);
        }
        for (Map.Entry entry : characters.entrySet()) {
            System.out.println(entry.getKey() + " - "
                    + entry.getValue());
        }

        ProgramRun.isExit("2");
    }

    public int count(char i) {
        return (int) Arrays.stream(inputString.split("")).filter(s -> s.equals(String.valueOf(i))).count();
    }

    public boolean isCharacter() {
        return charArray.length == 0;
    }

    private void readString() throws IOException {
        System.out.println("\nThis task takes a string from the console and extracts all characters\n" +
                "Latin / Cyrillic and sorts them by specifying the number of occurrences of each character. " +
                "\nEnter your string - ");
        inputString = reader.readLine().toLowerCase(Locale.ROOT);
        if (inputString.isEmpty()) {
            System.out.println("String is empty");
            ProgramRun.isExit("2");
        } else {

            charArray = Arrays.stream(inputString.split(""))
                    .filter(c -> c.matches("\\p{L}"))
                    .collect(Collectors.joining())
                    .toCharArray();
            if (isCharacter()) {
                System.out.println("There are no letters in this string.");
                ProgramRun.isExit("2");
            } else {
                Arrays.sort(charArray);
                inputString = String.valueOf(charArray);
                countCharacter();
            }
        }
    }
}
