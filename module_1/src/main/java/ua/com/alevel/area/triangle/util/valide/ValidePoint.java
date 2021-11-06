package ua.com.alevel.area.triangle.util.valide;

public final class ValidePoint {
    private ValidePoint() {
    }

    public static boolean valideInputPoint(String ponts) {

        if (ponts.isEmpty()) {
            System.out.println("Input Error!!! \nPlease, enter points : ");
            return false;
        }
        if (!ponts.matches("^([+-]?((\\d+\\.?\\d*)|(\\.\\d+)));\\s*([+-]?((\\d+\\.?\\d*)|(\\.\\d+)))$")) {
            System.out.println("Input Error!!! \nYou need to enter the coordinates of points in the following format - #;#\nPlease, enter points : ");
            return false;
        }
        return true;
    }
}
