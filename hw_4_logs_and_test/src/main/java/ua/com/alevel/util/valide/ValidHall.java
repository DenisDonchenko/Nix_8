package ua.com.alevel.util.valide;

import ua.com.alevel.util.ConstGlobal;

import java.util.regex.Pattern;

public final class ValidHall extends BaseValide {

    private ValidHall() {
    }

    public static boolean validCapacity(String capacity) {
        if (capacity.isEmpty()) {
            System.out.println(ConstGlobal.settings.getString("hall.capacity.empty"));
            return false;
        }
        if (!Pattern.matches(REGEX_CAPACITY, capacity)) {
            System.out.println(ConstGlobal.settings.getString("hall.capacity.format"));
            return false;
        }
        return true;
    }

}
