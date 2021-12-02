package ua.com.alevel;

import ua.com.alevel.mat.set.impl.MathSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgramRun {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void start() {
        startRun();
    }

    public void startRun() {
        startRunNavigation();
        String event;
        MathSet<Number> mathSet;
        try {
            event = reader.readLine();
            switch (event) {

                case "1" -> {
                    mathSet = new MathSet<>();
                    navigationMethods(mathSet);
                }
                case "2" -> {
                    int capacity = readCapacity();
                    mathSet = new MathSet<>(capacity);
                    navigationMethods(mathSet);
                }
                case "3" -> {
                    mathSet = new MathSet<>(readValues());
                    navigationMethods(mathSet);
                }
                case "0" -> System.exit(0);

                default -> startRun();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void navigationMethods(MathSet<Number> numberMathSet) {
        navigationMethodsPreview();
        String event;
        try {
            while ((event = reader.readLine()) != null) {
                switch (event) {
                    case "1" -> {
                        System.out.println(numberMathSet.toString());
                        navigationMethods(numberMathSet);
                    }
                    case "2" -> {
                        Number[] numbers = readValues();
                        numberMathSet.add(numbers);
                        navigationMethods(numberMathSet);
                    }
                    case "3" -> {
                        numberMathSet.join(createMathSet());
                        System.out.println(numberMathSet.toString());
                        navigationMethods(numberMathSet);
                    }
                    case "4" -> {
                        numberMathSet.intersection(createMathSet());
                        System.out.println(numberMathSet.toString());
                        navigationMethods(numberMathSet);
                    }
                    case "5" -> {
                        numberMathSet.sortDesc();
                        System.out.println(numberMathSet.toString());
                        navigationMethods(numberMathSet);
                    }
                    case "6" -> {
                        List<Integer> index = readIndices(numberMathSet.length());
                        numberMathSet.sortDesc(index.get(0), index.get(1));
                        System.out.println(numberMathSet.toString());
                        navigationMethods(numberMathSet);
                    }
                    case "7" -> {
                        numberMathSet.sortAsc();
                        System.out.println(numberMathSet.toString());
                        navigationMethods(numberMathSet);
                    }
                    case "8" -> {
                        List<Integer> index = readIndices(numberMathSet.length());
                        numberMathSet.sortAsc(index.get(0), index.get(1));
                        System.out.println(numberMathSet.toString());
                        navigationMethods(numberMathSet);
                    }
                    case "9" -> {
                        int index = readIndex(numberMathSet.length());
                        Number number = numberMathSet.get(index);
                        System.out.println("Number is " + number.doubleValue() + " by index " + index);
                        navigationMethods(numberMathSet);
                    }
                    case "10" -> {
                        Number number = numberMathSet.getMax();
                        System.out.println("Max value -  " + number.doubleValue());
                        navigationMethods(numberMathSet);
                    }
                    case "11" -> {
                        Number number = numberMathSet.getMin();
                        System.out.println("Min value -  " + number.doubleValue());
                        navigationMethods(numberMathSet);
                    }
                    case "12" -> {
                        Number number = numberMathSet.length();
                        System.out.println("Length mathSet -  " + number.doubleValue());
                        navigationMethods(numberMathSet);
                    }
                    case "13" -> {
                        Number number = numberMathSet.getAverage();
                        System.out.println("Average mathSet -  " + number.doubleValue());
                        navigationMethods(numberMathSet);
                    }
                    case "14" -> {
                        Number number = numberMathSet.getMedian();
                        System.out.println("Median mathSet -  " + number.doubleValue());
                        navigationMethods(numberMathSet);
                    }
                    case "15" -> {
                        numberMathSet.clear();
                        System.out.println("MathSet is clear");
                        navigationMethods(numberMathSet);
                    }
                    case "16" -> {
                        Number[] numbers = readValues();
                        numberMathSet.clear(numbers);
                        navigationMethods(numberMathSet);
                    }
                    case "0" -> System.exit(0);
                    default -> navigationMethods(numberMathSet);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void navigationMethodsPreview() {
        System.out.println();
        System.out.println(
                "Print mathSet, enter - 1     \t|\tAdd values, enter - 2\n" +
                        "Join math set, enter - 3     \t|\tIntersection math set, enter - 4\n" +
                        "Sort desc, enter - 5         \t|\tSort desc between firstIndex and  lastIndex, enter - 6\n" +
                        "Sort asc, enter - 7          \t|\tSort asc between firstIndex and  lastIndex, enter - 8\n" +
                        "Get value by index, enter - 9\t|\tGet max value, enter - 10\n" +
                        "Get min value, enter - 11    \t|\tGet length , enter - 12\n" +
                        "Get average value, enter - 13\t|\tGet median value, enter - 14\n" +
                        "Clear all MathSet, enter - 15\t|\tClear values in MathSet, enter - 16\n"
        );
    }

    private static void startRunNavigation() {
        System.out.println();
        System.out.println("Use collections MathSet");
        System.out.println("First you need to create MathSet ");
        System.out.println("Create MathSet by default - 1");
        System.out.println("Create MathSet with your capacity - 2");
        System.out.println("Create MathSet with your values - 3");

        System.out.println();
    }

    private static MathSet createMathSet() {
        Number[] numbers = readValues();
        return new MathSet(numbers);
    }

    private static int readIndex(int lengthArray) {
        System.out.println("Enter index :  ");
        int index = 0;
        try {
            index = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println("Error input index");
            readIndex(lengthArray);
        }
        if (index >= lengthArray) {
            System.out.println("The entered index is out of range from 1 to " + lengthArray);
            readIndex(lengthArray);
        }
        if (index < 1) {
            System.out.println("The entered index is out of the possible value - " + lengthArray);
            readIndex(lengthArray);
        }

        return index;
    }


    public static ArrayList<Integer> readIndices(int lengthArray) {
        ArrayList<Integer> indexes = new ArrayList<>(2);
        int firstIndex = 0;
        int lastIndex = 0;
        try {
            System.out.println("Enter first index : ");
            firstIndex = Integer.parseInt(reader.readLine());
            System.out.println("Enter last index : ");
            lastIndex = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException | IOException exception) {
            System.out.println("Input Error!!! Enter not a number!!!");
            readIndices(lengthArray);
        }
        if (lastIndex < firstIndex) {
            System.out.println("Input Error!!! First index should be less last index!");
            readIndices(lengthArray);
        }
        if (lastIndex >= lengthArray || firstIndex >= lengthArray) {
            System.out.println("The entered index is out of range from 1 to " + lengthArray);
            readIndices(lengthArray);
        }
        if (lastIndex < 1 || firstIndex < 1) {
            System.out.println("The entered index is out of the possible value - " + lengthArray);
            readIndices(lengthArray);
        }

        indexes.add(0, firstIndex);
        indexes.add(1, lastIndex);
        return indexes;
    }

    private static Number[] readValues() {
        System.out.println("Enter values. Can accept floating point numbers and negative numbers.\nExample (5, 54,-43,-3, 0.7, .43) ");
        String inputString = null;
        try {
            inputString = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pattern pattern = Pattern.compile("[+-]?((\\d+\\.?\\d*)|(\\.\\d+))");
        Matcher matcher = pattern.matcher(inputString);

        ArrayList<Number> numbersList = new ArrayList<>();
        int index = 0;
        while (matcher.find()) {
            double numberWithString = Double.parseDouble(matcher.group());
            numbersList.add(numberWithString);
        }

        Number[] array = new Number[numbersList.size()];

        for (int i = 0; i < numbersList.size(); i++) array[i] = numbersList.get(i);
        return array;
    }

    private static int readCapacity() {
        System.out.println(" Enter your capacity.");
        int capacity = 0;
        try {
            capacity = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            readCapacity();
        }
        return capacity;
    }


}
