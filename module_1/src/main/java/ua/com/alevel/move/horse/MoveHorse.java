package ua.com.alevel.move.horse;

import ua.com.alevel.move.horse.util.ValideCoordinates;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MoveHorse {
    private static int indexColumn = 0;
    private static int indexRow = 0;
    private static int lastIndexColumn;
    private static int lastIndexRow;
    private static String inputCoordinates = "";


    private static String[][] chessBoard =
            {
                    {"·", "·", "·", "·", "·", "·", "·", "·",},
                    {"·", "·", "·", "·", "·", "·", "·", "·",},
                    {"·", "·", "·", "·", "·", "·", "·", "·",},
                    {"·", "·", "·", "·", "·", "·", "·", "·",},
                    {"·", "·", "·", "·", "·", "·", "·", "·",},
                    {"·", "·", "·", "·", "·", "·", "·", "·",},
                    {"·", "·", "·", "·", "·", "·", "·", "·",},
                    {"·", "·", "·", "·", "·", "·", "·", "·",}
            };

    private static final Map<String, Integer> indexColumnChar =
            new HashMap<>() {{
                put("A", 1);
                put("B", 2);
                put("C", 3);
                put("D", 4);
                put("E", 5);
                put("F", 6);
                put("G", 7);
                put("H", 8);
            }};

    public static void run(BufferedReader reader) {
        preview();
        printBoard();
        while (true) {
            readCoordinates(reader);
            makeMove();
        }
    }

    private static void readCoordinates(BufferedReader reader) {

        System.out.println("Pleas enter coordinates : ");
        inputCoordinates = "";
        try {
            inputCoordinates = reader.readLine();
            if (!ValideCoordinates.checkCorrectnessInput(inputCoordinates)) {
                throw new IOException();
            }

            saveCoordinates();

            if (!ValideCoordinates.checkCorrectnessMove(lastIndexRow, lastIndexColumn, indexColumn, indexRow)) {
                throw new IOException();
            }

        } catch (IOException e) {
            inputCoordinates = "";
            readCoordinates(reader);
        }

        ValideCoordinates.isStart = true;

        lastIndexColumn = indexColumn;
        lastIndexRow = indexRow;
    }

    private static void saveCoordinates() {
        indexColumn = indexColumnChar.get(String.valueOf(inputCoordinates.charAt(0)).toUpperCase(Locale.ROOT)) - 1;
        indexRow = 8 - Integer.parseInt(String.valueOf(inputCoordinates.charAt(1)));
    }

    private static void makeMove() {
        chessBoard[indexRow][indexColumn] = "Х";
        printBoard();
        chessBoard[indexRow][indexColumn] = "·";
    }

    private static void printBoard() {
        int indexNumber = 8;

        System.out.println("    A B C D E F G H");
        System.out.println("    | | | | | | | |");
        for (int i = 0; i < chessBoard.length; i++) {
            System.out.print(indexNumber + " - ");

            for (int j = 0; j < chessBoard[i].length; j++) {
                System.out.print(chessBoard[i][j] + " ");
            }
            System.out.print(" - " + indexNumber);
            indexNumber--;
            System.out.println();
        }
        System.out.println("    | | | | | | | |");
        System.out.println("    A B C D E F G H");
    }

    private static void preview() {
        System.out.println("This application is chess horse simulator!!!\n" +
                "Coordinates must be entered in the form - H2, a5\n" +
                "Empty position - ·\n" +
                "Chess piece position - X\n");
        System.out.println("if you want return to main menu, entered - 0");
    }
}
