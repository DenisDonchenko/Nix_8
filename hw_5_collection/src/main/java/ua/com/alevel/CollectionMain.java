package ua.com.alevel;

import ua.com.alevel.mat.set.Set;
import ua.com.alevel.mat.set.impl.MathSet;

import java.util.ArrayList;

public class CollectionMain {
    public static void main(String[] args) {
        Set<Number> mathSet1 = new MathSet<>();
        Set<Number> mathSet2 = new MathSet<>();

        mathSet1.add(1, 2, 3, 4, 5, 6, 7, 8, 9);
        mathSet2.add(10,22,9,18,102,56,43);

        System.out.println( mathSet1.toString());

        mathSet1.sortDesc(mathSet2);
        System.out.println( mathSet1.toString());
    }
}
