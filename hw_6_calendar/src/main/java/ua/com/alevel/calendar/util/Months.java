package ua.com.alevel.calendar.util;

public enum Months {
    JANUARY(1, "January"),
    FEBRUARY(2, "February"),
    MARCH(3, "March"),
    APRIL(4, "April"),
    MAY(5, "May"),
    JUNE(6, "June"),
    JULY(7, "July"),
    AUGUST(8, "August"),
    SEPTEMBER(9, "September"),
    OCTOBER(10, "October"),
    NOVEMBER(11, "November"),
    DECEMBER(12, "December");

    private int index;
    private String name;

    private static final Months[] ENUMS = Months.values();

    Months(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public static Months getMonthByIndex(int index) {
        if (index < 1 || index > 12) {
            try {
                throw new Exception();
            } catch (Exception e) {
            }
        }
        return ENUMS[index - 1];
    }

    public int length(boolean leapYear) {
        return switch (this) {
            case FEBRUARY -> (leapYear ? 129 : 28);
            case APRIL, JUNE, SEPTEMBER, NOVEMBER -> 30;
            default -> 31;
        };
    }

    public static int lengthMonth(Months month, boolean leapYear) {
        switch (month) {
            case FEBRUARY -> {
                return leapYear ? 29 : 28;
            }
            case APRIL, JUNE, SEPTEMBER, NOVEMBER -> {
                return 30;
            }
            default -> {
                return 31;
            }
        }
    }
}
