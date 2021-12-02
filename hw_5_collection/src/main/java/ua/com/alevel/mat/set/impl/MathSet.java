package ua.com.alevel.mat.set.impl;

import ua.com.alevel.mat.set.Set;
import ua.com.alevel.mat.set.util.HelperArray;

import java.math.BigDecimal;

public class MathSet<N extends Number> implements Set<Number> {

    private Number[] arraySet;
    private int realSizeArray = 0;
    private int capacity = 10;
    private int indexNewNumber = 0;

    public MathSet() {
        this.arraySet = new Number[capacity];
    }

    public MathSet(int capacity) {
        this.capacity = capacity;
        this.arraySet = new Number[capacity];
    }

    public MathSet(Number[] numbers) {
        this.arraySet = new Number[capacity];
        arrayToMathSet(numbers);
    }

    public MathSet(Number[]... numbers) {
        this.arraySet = new Number[capacity];
        manyArraysToMathSet(numbers);
    }

    public MathSet(MathSet mathSet) {
        mathSetToMathSet(mathSet);
    }

    @Override
    public void add(Number n) {
        if (realSizeArray == capacity - 1) {
            arraySet = HelperArray.newCapacity(capacity, arraySet);
            capacity = arraySet.length;
        }
        if (!existNumber(n)) {
            arraySet[indexNewNumber] = n;
            indexNewNumber++;
            realSizeArray++;
        }
    }

    @Override
    public void add(Number... n) {
        for (Number number : n) {
            if (!existNumber(number)) {
                add(number);
            }
        }
    }

    @Override
    public void join(Set<Number> numberSet) {
        for (int i = 0; i < numberSet.length(); i++) {
            if (!existNumber(numberSet.get(i))) {
                add(numberSet.get(i));
            }
        }
    }

    @Override
    public void join(Set<Number>... ms) {
        for (Set<Number> m : ms) {
            join(m);
        }
    }

    @Override
    public void intersection(Set<Number> numberSet) {
        for (int i = 0; i < realSizeArray; i++) {
            if (!existNumber(arraySet[i], numberSet)) {
                HelperArray.removeItems(arraySet, i);
                realSizeArray--;
            }
        }
    }

    @Override
    public void intersection(Set<Number>... ms) {
        for (Set<Number> m : ms) {
            intersection(m);
        }
    }

    @Override
    public void sortDesc() {
        for (int i = 1; i < realSizeArray; i++) {
            Number max = arraySet[i];
            int j = i - 1;
            while (j >= 0 && arraySet[j].doubleValue() < max.doubleValue()) {
                arraySet[j + 1] = arraySet[j];
                j--;
            }
            arraySet[j + 1] = max;
        }
    }

    @Override
    public void sortDesc(int firstIndex, int lastIndex) {
        try {
            for (int i = firstIndex; i < lastIndex + 1; i++) {
                Number max = arraySet[i];
                int j = i - 1;
                while (j >= firstIndex && arraySet[j].doubleValue() < max.doubleValue()) {
                    arraySet[j + 1] = arraySet[j];
                    j--;
                }
                arraySet[j + 1] = max;
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Index out of bounds for length " + length());
        }
    }

    @Override
    public void sortDesc(Set<Number> numberSet) {
        this.realSizeArray = numberSet.length();
        this.arraySet = numberSet.toArray();

        sortDesc();
    }

    @Override
    public void sortAsc() {
        for (int i = 1; i < realSizeArray; i++) {
            Number max = arraySet[i];
            int j = i - 1;
            while (j >= 0 && arraySet[j].doubleValue() > max.doubleValue()) {
                arraySet[j + 1] = arraySet[j];
                j--;
            }
            arraySet[j + 1] = max;
        }
    }

    @Override
    public void sortAsc(int firstIndex, int lastIndex) {
        try {
            for (int i = firstIndex; i < lastIndex + 1; i++) {
                Number max = arraySet[i];
                int j = i - 1;
                while (j >= firstIndex && arraySet[j].doubleValue() > max.doubleValue()) {
                    arraySet[j + 1] = arraySet[j];
                    j--;
                }
                arraySet[j + 1] = max;
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Index out of bounds for length " + length());
        }
    }

    @Override
    public void sortAsc(Set<Number> numberSet) {
        this.realSizeArray = numberSet.length();
        this.arraySet = numberSet.toArray();

        sortAsc();
    }

    @Override
    public Number get(int index) {
        if (index >= 0 && index < realSizeArray) {
            return arraySet[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    @Override
    public Number getMin() {
        Number min = arraySet[0];
        for (int i = 1; i < realSizeArray; i++) {
            if (arraySet[i].doubleValue() < min.doubleValue()) {
                min = arraySet[i];
            }
        }
        return min;
    }

    @Override
    public Number getAverage() {
        double average = 0;
        for (int i = 1; i < realSizeArray; i++) {
            average += arraySet[i].doubleValue();
        }

        return new BigDecimal(average / length()).setScale(2, BigDecimal.ROUND_DOWN);
    }

    @Override
    public Number getMax() {
        Number max = arraySet[0];
        for (int i = 1; i < realSizeArray; i++) {
            if (arraySet[i].doubleValue() > max.doubleValue()) {
                max = arraySet[i];
            }
        }
        return max;

    }

    @Override
    public Number getMedian() {

        sortAsc();
        Number median;
        if (realSizeArray % 2 == 0)
            median = (arraySet[realSizeArray / 2].doubleValue() + arraySet[realSizeArray / 2 - 1].doubleValue()) / 2;
        else
            median = arraySet[realSizeArray / 2];
        return median;
    }

    @Override
    public Number[] toArray() {

        Number[] result = new Number[realSizeArray];
        for (int i = 0; i < realSizeArray; i++) {
            result[i] = arraySet[i];
        }
        return result;
    }


    @Override
    public Number[] toArray(int firstIndex, int lastIndex) {
        int lengthArray = (lastIndex - firstIndex) + 1;

        Number[] numbersArray = new Number[lengthArray];
        try {
            int indexArrayReturn = 0;
            for (int i = firstIndex; i <= lastIndex; i++) {
                numbersArray[indexArrayReturn] = arraySet[i];
                indexArrayReturn++;
            }

        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Index out of bounds for length " + length());
        }
        return numbersArray;
    }

    @Override
    public MathSet cut(int firstIndex, int lastIndex) {
        int lengthArray = (lastIndex - firstIndex) + 1;
        Number[] numbersCut = new Number[lengthArray];
        try {
            int indexArrayReturn = 0;
            for (int i = firstIndex; i <= lastIndex; i++) {
                numbersCut[indexArrayReturn] = arraySet[i];
                indexArrayReturn++;
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Index out of bounds for length " + length());
        }
        return new MathSet(numbersCut);
    }

    @Override
    public void clear() {
        this.capacity = 10;
        this.arraySet = new Number[capacity];
        realSizeArray = 0;
    }

    @Override
    public void clear(Number[] numbers) {
        for (int i = 0; i < numbers.length; i++) {

            if (existNumber(numbers[i])) {
                System.out.print("[" + i + "]" + numbers[i] + " ");
                int indexArr = getIndexNumber(numbers[i]);
                HelperArray.removeItems(arraySet, indexArr);
                realSizeArray--;
            }
        }
        System.out.println();
    }

    @Override
    public int length() {
        return realSizeArray;
    }

    @Override
    public boolean existNumber(Number number) {
        for (int i = 0; i < realSizeArray; i++) {
            if (number.doubleValue() == arraySet[i].doubleValue()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String arrayString = "";
        if (realSizeArray == 0) {
            return "MathSet : {}";
        }
        for (int i = 0; i < realSizeArray; i++) {
            if (i == 0) {
                arrayString += " " + "[" + i + "]" + arraySet[i];
            } else
                arrayString += ", " + "[" + i + "]" + arraySet[i];
        }

        return "MathSet : [ " + arrayString + " ]";
    }

    private void mathSetToMathSet(MathSet mathSet) {
        this.realSizeArray = mathSet.length();
        this.arraySet = mathSet.toArray();
    }

    private void arrayToMathSet(Number[] numbers) {
        for (Number n : numbers) {
            add(n);
        }
    }

    private void manyArraysToMathSet(Number[]... numbers) {
        for (int i = 0; i < numbers.length; i++) {
            Number[] numbers1 = numbers[i];
            for (Number number : numbers1) {
                add(number);
            }
        }
    }

    private boolean existNumber(Number number, Set<Number> numberSet) {
        for (int i = 0; i < numberSet.length(); i++) {
            if (numberSet.get(i) == number) {
                return true;
            }
        }
        return false;
    }

    private int getIndexNumber(Number number) {
        for (int i = 0; i < realSizeArray; i++) {
            if (number.doubleValue() == arraySet[i].doubleValue()) {
                return i;
            }
        }
        return 0;
    }
}

