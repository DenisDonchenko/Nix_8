package ua.com.alevel.move.horse;

import ua.com.alevel.move.horse.util.ValideCoordinates;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MoveHorse {
    private int indexColumn = 0;
    private int indexRow = 0;
    private int lastIndexColumn;
    private int lastIndexRow;
    private String inputCoordinates = "";
    private BufferedReader reader;

    private String[][] chessBoard =
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

    private final Map<String, Integer> indexColumnChar = new HashMap<>() {{
                put("A", 1);
                put("B", 2);
                put("C", 3);
                put("D", 4);
                put("E", 5);
                put("F", 6);
                put("G", 7);
                put("H", 8);
            }};

    public MoveHorse(BufferedReader reader) {
        this.reader = reader;
    }

    public void start() {
        preview();
        printBoard();
        while (true) {
            readCoordinates();
            makeMove();
        }
    }

    private void readCoordinates() {

        System.out.println("Please enter coordinates : ");
        inputCoordinates = "";
        try {
            inputCoordinates = reader.readLine();
            if (!ValideCoordinates.checkCorrectnessInput(inputCoordinates)) {
                throw new Exception();
            }

            saveCoordinates();

            if (!ValideCoordinates.checkCorrectnessMove(lastIndexRow, lastIndexColumn, indexColumn, indexRow)) {
                throw new Exception();
            }

        } catch (Exception ex) {
            inputCoordinates = "";
            readCoordinates();
        }

        ValideCoordinates.isStart = true;

        lastIndexColumn = indexColumn;
        lastIndexRow = indexRow;
    }

    private void saveCoordinates() {
        indexColumn = indexColumnChar.get(String.valueOf(inputCoordinates.charAt(0)).toUpperCase(Locale.ROOT)) - 1;
        indexRow = 8 - Integer.parseInt(String.valueOf(inputCoordinates.charAt(1)));
    }

    private void makeMove() {
        chessBoard[indexRow][indexColumn] = "Х";
        printBoard();
        chessBoard[indexRow][indexColumn] = "·";
    }

    private void printBoard() {
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

    private void preview() {
        System.out.println("This application is chess horse simulator!!!\n" +
                "Coordinates must be entered in the form - H2, a5\n\n" +
                "Empty position - ·\n" +
                "Chess piece position - X\n");
        System.out.println("if you want return to main menu, entered - 0");
    }
}
