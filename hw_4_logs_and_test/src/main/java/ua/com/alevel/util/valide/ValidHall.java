package ua.com.alevel.util.valide;

import java.util.regex.Pattern;

public final class ValidHall extends BaseValide {

    private ValidHall() {
    }

    public static boolean validCapacity(String capacity) {
        if (capacity.isEmpty()) {
            System.out.println(settings.getString("hall.capacity.empty"));
            return false;
        }
        if (!Pattern.matches(REGEX_CAPACITY, capacity)) {
            System.out.println(settings.getString("hall.capacity.format"));
            return false;
        }
        return true;
    }

}
