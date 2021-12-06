package ua.com.alevel.calendar;

import ua.com.alevel.calendar.date.Date;
import ua.com.alevel.calendar.util.Months;

public class Calendar  {

    private final Date date;
    private final String inputFormatByDefault = "dd-mm-yyyy";
    private final String outputFormatDefault = "dd-mm-yyyy";

    public Calendar() {
        this.date = new Date(5, Months.getMonthByIndex(12), 2021, 0, 0, 0, 0, inputFormatByDefault, outputFormatDefault);
    }

    public Calendar(int day, int moth, int year) {
        this.date = new Date(day, Months.getMonthByIndex(moth), year, 0, 0, 0, 0, inputFormatByDefault, outputFormatDefault);
    }

    public String getDate() {
        return date.toString();
    }

    public void editFormatInput(String inputFormat) {
        this.date.setInputFormat(inputFormat);
    }

    public void editFormatOutput(String outputFormat) {
        this.date.setOutputFormat(outputFormat);
    }

    public int lengthMonth() {
        return date.getMonth().length(date.isLeapYear());
    }

    public void plusYears(int yearsToAdd) {
        date.setYear(date.getYear() + yearsToAdd);
    }

    public void minusYears(int yearsToRemove) {
        date.setYear(date.getYear() - yearsToRemove);
    }

    public void minusMonths(int monthsToRemove) {
        plusMonths(-monthsToRemove);
    }

    public void plusMonths(int monthsToAdd) {
        long monthCount = date.getYear() * 12L + (date.getMonth().getIndex() - 1);
        long calcMonths = monthCount + monthsToAdd;
        int newYear = (int) Math.floorDiv(calcMonths, 12);
        int newMonth = Math.floorMod(calcMonths, 12) + 1;
        date.setYear(newYear);
        date.setMonth(Months.getMonthByIndex(Math.abs(newMonth)));
    }

    public void minusDays(int daysToRemove) {
        plusDays(-daysToRemove);
    }

    public void plusHours(int hoursToAdd) {

    }

    public void minusHours(int hoursToRemove) {

    }

    public void plusMinutes(int minutesToAdd) {

    }

    public void minusMinutes(int minutesToRemove) {

    }

    public void plusSeconds(int secondsToAdd) {

    }

    public void minusSeconds(int secondsToRemove) {

    }

    public void plusDays(int daysToAdd) {
        int offset = offsetDays(date.getDay(), date.getMonth().getIndex());
        int remDays = date.isLeapYear() ? (366 - offset) : (365 - offset);

        int yearNow = date.getYear();
        int resultYear;
        int shiftDays;

        if (daysToAdd <= remDays) {
            resultYear = yearNow;
            shiftDays = offset + daysToAdd;
        } else {

            daysToAdd -= remDays;
            resultYear = yearNow + 1;
            int countDaysInYear = date.isLeapYear() ? 366 : 365;
            while (daysToAdd >= countDaysInYear) {
                daysToAdd -= countDaysInYear;
                resultYear++;
                countDaysInYear = date.isLeapYear() ? 366 : 365;
            }
            shiftDays = daysToAdd;
        }
        revoffsetDays(shiftDays, resultYear);
    }


    private int offsetDays(int day, int month) {
        int offset = day;

        switch (month - 1) {
            case 11 -> offset += 335;
            case 10 -> offset += 304;
            case 9 -> offset += 273;
            case 8 -> offset += 243;
            case 7 -> offset += 212;
            case 6 -> offset += 181;
            case 5 -> offset += 151;
            case 4 -> offset += 120;
            case 3 -> offset += 90;
            case 2 -> offset += date.isLeapYear() ? 60 : 59;
            case 1 -> offset += 31;
        }
        return offset;
    }

    public void revoffsetDays(int offset, int year) {
        int i;
        for (i = 1; i <= 12; i++) {
            int lengthMonth = Months.lengthMonth(Months.getMonthByIndex(i), date.isLeapYear());
            if (offset <= lengthMonth)
                break;
            offset -= lengthMonth;
        }
        date.setYear(year);
        date.setMonth(Months.getMonthByIndex(i));
        date.setDay(offset);
    }

}

