package ua.com.alevel.takesAndSortingChar;

import ua.com.alevel.ProgramRun;

import java.io.BufferedReader;
import java.util.*;
import java.util.stream.Collectors;

public class TakesAndSortingCharWithString {
    private char[] charArray;
    private String inputString = null;
    private HashMap<Character, Integer> characters = new HashMap<>();
    private BufferedReader reader;

    public TakesAndSortingCharWithString(BufferedReader reader) {
        this.reader = reader;
    }

    public void run(){
        readString();
        countCharacter();
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

    private void readString() {
        try {
            System.out.println("\n This task takes a string from the console and extracts all characters\n" +
                    " Latin / Cyrillic and sorts them by specifying the number of occurrences of each character. " +
                    "\n Enter your string - ");
            inputString = reader.readLine().toLowerCase(Locale.ROOT);
            if(inputString.isEmpty()){
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println(" String is empty");
            ProgramRun.run();
        }

        charArray = Arrays.stream(inputString.split(""))
                .filter(c -> c.matches("\\p{L}"))
                .collect(Collectors.joining())
                .toCharArray();
        Arrays.sort(charArray);
        inputString = String.valueOf(charArray);
    }
}
