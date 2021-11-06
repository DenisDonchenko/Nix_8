package ua.com.alevel.unique.symbol;


import ua.com.alevel.unique.symbol.util.ValideInputString;

import java.io.BufferedReader;
import java.util.*;

public class UniqueNumber {
    private List<String> arrayNumber = new ArrayList<>();
    private BufferedReader reader;
    private String inputArrayNumber = "";
    public UniqueNumber(BufferedReader reader) {
        this.reader = reader;
    }

    public void start() {
        preview();
        readString();
        printArray();
        System.out.println("\nCount unique number - " + uniqueCount());
        arrayNumber.removeAll(arrayNumber);
    }

    private int uniqueCount() {
        Set<String> mySet = new HashSet<>();
        for (String x : arrayNumber) {
            mySet.add(x);
        }
        return mySet.size();
    }

    private void printArray() {
        System.out.print("Array of numbers - " + arrayNumber);
    }

    private void readString() {
        System.out.println("Enter numbers separated by a space (Example - 1 2 3 4 5)");


        try {
            inputArrayNumber = reader.readLine().trim();
            if (!ValideInputString.valideString(inputArrayNumber)) {
                throw new Exception();
            }
        } catch (Exception e) {
            readString();
        }
        arrayNumber = new ArrayList<>(Arrays.asList(inputArrayNumber.split(" ")));


    }

    private void preview() {
        System.out.println("\nThis application returns the number of unique characters!!!");
        System.out.println("if you want exit, select - 0");
    }

}
