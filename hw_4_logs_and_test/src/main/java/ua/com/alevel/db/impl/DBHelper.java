package ua.com.alevel.db.impl;

import java.util.Arrays;

public final class DBHelper {
    private DBHelper() {
    }

    public static <ARRAY> ARRAY[] newCapacity(int capacity, ARRAY[] array) {
        capacity = capacity + (capacity / 2);
        array = Arrays.copyOf(array, capacity);

        return array;
    }


    public static <ARRAY> ARRAY[] removeItems(ARRAY[] array, int... r) {
        int shift = 0;
        for (int i = 0; i < array.length; i++) {
            if (shift < r.length && i == r[shift])
                shift++;
            else
                array[i - shift] = array[i];
        }
        for (int i = array.length - shift; i < array.length; i++)
            array[i] = null;

        return array;
    }

}
