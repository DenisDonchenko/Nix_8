package ua.com.alevel;

import ua.com.alevel.reverse.strings.ReverseString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProgramRun {

    private static String inputString = "";
    private static String substring = "";
    private static int firstIndex = 0;
    private static int lastIndex = 0;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void run() {
        preview();
        String event;
        try {
            while ((event = reader.readLine()) != null) {
                switch (event) {
                    case "1": {
                        System.out.println("This application reverse a string.\nThe string must not be empty!!!\n");
                        readString();
                        System.out.println("Result - " + ReverseString.reverse(inputString));
                        isExit("1");
                    }
                    break;
                    case "2": {
                        System.out.println("This application reverse substring in you string." +
                                "\nThe string and substring must not be empty!!!\n" +
                                "The substring must be present in the string!!!\n");
                        readString();
                        readSubstring();
                        System.out.println("Result - " +ReverseString.reverse(inputString, substring));
                        isExit("2");
                    }
                    break;
                    case "3": {
                        System.out.println("This application reverse substring in you string between start index and last index.");
                        readString();
                        readIndices();
                        System.out.println("Result - " +ReverseString.reverse(inputString, firstIndex, lastIndex));
                        isExit("3");
                    }
                    break;
                    case "0": {
                        System.exit(0);
                    }
                    break;
                    default: {
                        run();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readString() throws IOException {
        System.out.println("Enter string : ");
        inputString = reader.readLine();
        if (inputString.isEmpty()) {
            System.out.println("String is empty, please enter a non-empty string!!! ");
            readString();
        }
    }

    public static void readSubstring() throws IOException {
        System.out.println("Enter substring : ");
        substring = reader.readLine();
        if (substring.isEmpty()) {
            System.out.println("Substring is empty, please enter a non-empty substring!!! ");
            readSubstring();
        }
        if (!inputString.contains(substring)) {
            System.out.println("The string not contain the given substring, please enter substring!!!");
            readSubstring();
        }
    }

    public static void readIndices() throws IOException {
        try {
            System.out.println("Enter first index : ");
            firstIndex = Integer.parseInt(reader.readLine());
            System.out.println("Enter last index : ");
            lastIndex = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException exception) {
            System.out.println("Input Error!!! Enter not a number!!!");
            readIndices();
        }
        if (lastIndex < firstIndex) {
            System.out.println("Input Error!!! First index should be less last index!");
            readIndices();
        }
        if (lastIndex >= inputString.length() || firstIndex >= inputString.length()) {
            System.out.println("The entered index is out of range from 1 to " + inputString.length());
            readIndices();
        }
        if (lastIndex < 1 || firstIndex < 1) {
            System.out.println("The entered index is out of the possible value - " + inputString.length());
            readIndices();
        }

    }

    private static void preview() {
        System.out.println("if you want reverse you string please select 1");
        System.out.println("if you want reverse substring in you string, please select 2");
        System.out.println("if you want reverse substring in you string between start index and last index, please select 3");
        System.out.println("if you want run exit, please select 0");
        System.out.println("Make your choice:");
    }

    public static void isExit(String numberTask) {
        System.out.println("\nIf you want continue, please select " + numberTask +
                "\nIf you want exit to the main menu, please select enter.");
    }
}
