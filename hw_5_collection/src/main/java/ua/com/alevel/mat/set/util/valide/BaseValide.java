package ua.com.alevel.mat.set.util.valide;

import ua.com.alevel.mat.set.util.ConstGlobal;

public class BaseValide {

    public static boolean validIndex(int index, int lengthArray) {
        if (index >= lengthArray) {
            System.out.println(ConstGlobal.settings.getString("index.error" + lengthArray));
            return false;
        }
        if (index < 1) {
            System.out.println(ConstGlobal.settings.getString("index.error.length" + lengthArray));
            return false;
        }
        return true;
    }

    public static boolean validIndexes(int firstIndex, int lastIndex, int lengthArray) {
        if (lastIndex < firstIndex) {
            System.out.println(ConstGlobal.settings.getString("indexes.error.input.less.last.index"));
            return false;
        }
        if (lastIndex >= lengthArray || firstIndex >= lengthArray) {
            System.out.println(ConstGlobal.settings.getString("indexes.error.input.length.array" + lengthArray));
            return false;
        }
        if (lastIndex < 1 || firstIndex < 1) {
            System.out.println(ConstGlobal.settings.getString("indexes.error.input.smaller.one" + lengthArray));

            return false;
        }
        return true;
    }
}
