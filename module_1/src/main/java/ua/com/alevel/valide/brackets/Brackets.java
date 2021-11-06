package ua.com.alevel.valide.brackets;

import java.io.BufferedReader;
import java.io.IOException;

public class Brackets {

    private int countSquareBrackets = 0;
    private int countRoundBrackets = 0;
    private int countCurlyBraces = 0;

    private String inputString;
    private BufferedReader reader;

    public Brackets(BufferedReader reader) {
        this.reader = reader;
    }

    public void start() {
        preview();
            readString();
            if (!validParentheses()) {
                System.out.println("This line is invalid please re-enter");
            } else {
                System.out.println("This line is correct.");
            }
    }

    private boolean validParentheses() {

        if (inputString.isEmpty()) {
            return true;
        }

        if (inputString.charAt(0) == ')' || inputString.charAt(0) == ']' || inputString.charAt(0) == '}') {
            return false;
        }

        for (int i = 0; i < inputString.length(); i++) {

            countBrackets(inputString.charAt(i));
            if (countRoundBrackets < 0 || countSquareBrackets < 0 || countCurlyBraces < 0) {
                return false;
            }
        }
        return checkBrackets();
    }

    private boolean checkBrackets() {
        if (countRoundBrackets == 0 && countSquareBrackets == 0 && countCurlyBraces == 0) {
            return true;
        } else return false;
    }

    private void countBrackets(char brace) {

        switch (brace) {
            case '(':
                countRoundBrackets++;
                break;
            case ')':
                countRoundBrackets--;
                break;
            case '[':
                countSquareBrackets++;
                break;
            case ']':
                countSquareBrackets--;
                break;
            case '{':
                countCurlyBraces++;
                break;
            case '}':
                countCurlyBraces--;
                break;
        }

    }

    private void preview() {
        System.out.println("\nValide brackets in input string.\n");
        System.out.println("if you want return to main menu, entered - 0");
    }

    private void readString() {
        System.out.println("Enter string:");
        try {
            inputString = reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
