package ua.com.alevel.unique.symbol.util;

public final class ValideInputString {
    private ValideInputString() {

    }

    public static boolean valideString(String inputString) {
        if (inputString.isEmpty()) {
            System.out.println("Error!!! Input empty \n");
            return false;
        }
        if (!inputString.matches("^[0-9 ]+$")) {
            System.out.println("Incorrect input, numbers and spaces are allowed");
            return false;
        }
        return true;
    }
}
