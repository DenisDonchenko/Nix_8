package ua.com.alevel.sumNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumNumbersFromString {
    private static double number;
    private static String inputString;

    private static void readString(BufferedReader reader) throws IOException {
        try {

            System.out.println("This task takes a string from the console and extracts all the numbers and finds their sum.\n" +
                    "The program can accept floating point numbers and negative numbers.\n" +
                    "Example (5, 54,-43,-3, 0.7, .43) \n" +
                    "Enter your string : ");
            inputString = reader.readLine();
            if (inputString.isEmpty()) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("String is empty");
        }
    }

    public static void run(BufferedReader reader) throws IOException {

        readString(reader);
        Pattern pattern = Pattern.compile("[+-]?((\\d+\\.?\\d*)|(\\.\\d+))");
        Matcher matcher = pattern.matcher(inputString);

        System.out.print("This string has next numbers : ");
        while (matcher.find()) {
            double numberWithString = Double.parseDouble(matcher.group());
            System.out.print(numberWithString + ", ");
            number += numberWithString;

        }
        System.out.println("\nResult = " + number);
        number = 0;
    }
}
