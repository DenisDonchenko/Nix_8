package ua.com.alevel.mat.set;

public interface Set<NUMBER> {

    void add(NUMBER n);

    void add(NUMBER... n);

    void join(Set<NUMBER> numberSet);

    void join(Set<NUMBER>... ms);

    void intersection(Set<NUMBER> ms);

    void intersection(Set<NUMBER>... ms);

    void sortDesc();

    void sortDesc(int firstIndex, int lastIndex);

    void sortDesc(Set<NUMBER> numberSet);

    void sortAsc();

    void sortAsc(int firstIndex, int lastIndex);

    void sortAsc(Set<NUMBER> numberSet);

    NUMBER get(int index);

    NUMBER getMax();

    NUMBER getMin();

    NUMBER getAverage();

    NUMBER getMedian();

    NUMBER[] toArray();

    NUMBER[] toArray(int firstIndex, int lastIndex);

    Set<NUMBER> cut(int firstIndex, int lastIndex);

    void clear();

    void clear(Number[] Numbers);

    String toString();

    int length();

    boolean existNumber(Number number);
}
