package ua.com.alevel.unique.symbol;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class UniqueNumber {
    private static List<String> arrayNumber = new ArrayList<>();

    public static void start(BufferedReader reader) {
        preview();
        readArray(reader);
        printArray();
        System.out.println("\nCount unique number - " + uniqueCount());
        arrayNumber.removeAll(arrayNumber);
    }

    private static int uniqueCount() {
        Set<String> mySet = new HashSet<>();
        for (String x : arrayNumber) {
            mySet.add(x);
        }
        return mySet.size();
    }

    private static void printArray() {
        System.out.print("Array of numbers - " + arrayNumber);
    }

    private static void readArray(BufferedReader reader) {
        System.out.println("Enter numbers separated by a space (Example - 1 2 3 4 5)");
        String inputArrayNumber = "";

        try {
            inputArrayNumber = reader.readLine().trim();
            if (inputArrayNumber.isEmpty()) {
                System.out.println("Not is empty\n");
                readArray(reader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (isNumbers(inputArrayNumber)) {
            arrayNumber = new ArrayList<>(Arrays.asList(inputArrayNumber.split(" ")));

        } else {
            System.out.println("\nOnly numbers and spaces are allowed!!!\n");
            readArray(reader);
        }
    }

    private static void preview() {
        System.out.println("\nThis application returns the number of unique characters!!!");
        System.out.println("if you want exit, select - 0");
    }

    private static boolean isNumbers(String arrayNumber) {
        return arrayNumber.matches("[0-9.\\s+]+");

    }
}
