package ua.com.alevel.sumNumbers;

import ua.com.alevel.ProgramRun;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumNumbersFromString {

    private double number;
    private String inputString;
    private BufferedReader reader;

    public SumNumbersFromString(BufferedReader reader) {
        this.reader = reader;
    }

    private void readString() throws IOException {
        try {
            System.out.println("This task takes a string from the console and extracts all the numbers and finds their sum.\n" +
                    "The program can accept floating point numbers and negative numbers.\n" +
                    "Example (5, 54,-43,-3, 0.7, .43) \n" +
                    "Enter your string : ");
            inputString = reader.readLine();
            if (inputString.isEmpty()) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("String is empty");
            ProgramRun.isExit("1");
        }
        sumNumber();
    }

    private void sumNumber() {
        List<Double> numbersFromString = new ArrayList<>();
        Pattern pattern = Pattern.compile("[+-]?((\\d+\\.?\\d*)|(\\.\\d+))");
        Matcher matcher = pattern.matcher(inputString);

        while (matcher.find()) {
            double numberWithString = Double.parseDouble(matcher.group());
            numbersFromString.add(numberWithString);
            number += numberWithString;
        }
        if (numbersFromString.isEmpty()) {
            System.out.println("Numbers are missing in the string - " + inputString);
            ProgramRun.isExit("1");
        } else {
            System.out.print("This string(" + inputString + ") has next numbers : " + numbersFromString);
            System.out.printf("\nResult = %.2f", number);
            number = 0;
            ProgramRun.isExit("1");
        }
    }

    public void run() throws IOException {
        readString();
    }
}
