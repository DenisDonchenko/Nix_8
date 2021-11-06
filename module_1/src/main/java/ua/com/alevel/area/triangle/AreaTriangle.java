package ua.com.alevel.area.triangle;

import ua.com.alevel.area.triangle.util.valide.ValidePoint;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AreaTriangle {

    private double area;

    private List<Double> pointsTriangle = new ArrayList<>(6);
    private String inputPoint;

    private BufferedReader reader;

    public AreaTriangle(BufferedReader reader) {
        this.reader = reader;
    }

    public void start() {
        preview();
        readPoints();
    }


    private void readPoints() {
        readPoint_A();
        readPoint_B();
        readPoint_C();

        areaСalculation();
        printOutput();
    }

    private void readConsole() {
        try {
            inputPoint = reader.readLine();
            if (!ValidePoint.valideInputPoint(inputPoint)) {
                throw new Exception();
            }

        } catch (Exception e) {
            readConsole();
        }
    }

    private void areaСalculation() {
        double determinant = ((pointsTriangle.get(0) - pointsTriangle.get(4)) * (pointsTriangle.get(3) - pointsTriangle.get(5))) -
                ((pointsTriangle.get(1) - pointsTriangle.get(5)) * (pointsTriangle.get(2) - pointsTriangle.get(4)));
        this.area = Math.abs(determinant) / 2;
    }

    private void readPoint_A() {
        System.out.println("Please, enter points A : ");
        readConsole();
        addPointsToList();
    }

    private void readPoint_B() {
        System.out.println("Please, enter points B : ");
        readConsole();
        addPointsToList();
    }

    private void readPoint_C() {
        System.out.println("Please, enter points C : ");
        readConsole();
        addPointsToList();
    }

    private void addPointsToList() {
        Pattern pattern = Pattern.compile("([+-]?((\\d+\\.?\\d*)|(\\.\\d+)))");
        Matcher matcher = pattern.matcher(inputPoint);
        while (matcher.find()) {
            pointsTriangle.add(Double.valueOf(matcher.group()));
        }
    }

    private void preview() {
        System.out.println("\nArea of a triangle by its points.\n" +
                "This application can accept floating point numbers and negative numbers.\n" +
                "Entering coordinates in the next format - #;# \nExample -2;1");
        System.out.println("if you want return to main menu, entered - 0");
    }

    private void printOutput() {
        System.out.println("Triangle with next points ");
        System.out.println("A:(" + pointsTriangle.get(0) + ";" + pointsTriangle.get(1) + ")");
        System.out.println("B:(" + pointsTriangle.get(2) + ";" + pointsTriangle.get(3) + ")");
        System.out.println("C:(" + pointsTriangle.get(4) + ";" + pointsTriangle.get(5) + ")");
        System.out.println("Area = " + area);
    }
}
