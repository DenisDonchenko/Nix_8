package ua.com.alevel.move.horse.util;

import ua.com.alevel.ProgramRun;

public final class ValideCoordinates {

    public static boolean isStart = false;

    private ValideCoordinates() { }

    public static boolean checkCorrectnessInput(String coordinates) {
        if (coordinates.equals("0")) {
            ProgramRun.run();
        }
        if (!coordinates.matches("[A-Ha-h]([1-8])${2}")) {
            System.out.println("Error input coordinates. Coordinates must be written in the form С6 or h4!!!");
            return false;
        }
        if (coordinates.isBlank()) {
            System.out.println("Coordinates is empty!!!");
            return false;
        }
        return true;
    }

    public static boolean checkCorrectnessMove(int lastIndexRow, int lastIndexColumn, int indexColumn, int indexRow) {
        if (isStart) {
            if (indexRow + 2 == lastIndexRow && (indexColumn + 1 == lastIndexColumn || indexColumn - 1 == lastIndexColumn)) {
                return true;
            }

            if (indexRow - 2 == lastIndexRow && (indexColumn + 1 == lastIndexColumn || indexColumn - 1 == lastIndexColumn)) {
                return true;
            }

            if (indexColumn + 2 == lastIndexColumn && (indexRow + 1 == lastIndexRow || indexRow - 1 == lastIndexRow)) {
                return true;
            }
            if (indexColumn - 2 == lastIndexColumn && (indexRow + 1 == lastIndexRow || indexRow - 1 == lastIndexRow)) {
                return true;
            } else {
                System.out.println("Error input new index row coordinates\nIncorrect horse move! \n" +
                                   "The horse may move two squares vertically and one square horizontally, \n" +
                                   "or two squares horizontally and one square vertically. ");
                return false;
            }
        }
        return true;
    }
}
