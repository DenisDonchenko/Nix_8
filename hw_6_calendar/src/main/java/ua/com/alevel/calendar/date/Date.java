package ua.com.alevel.calendar.date;

import ua.com.alevel.calendar.util.Months;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Date {
    private int day;
    private Months month;
    private int year;
    private int hour;
    private int minute;
    private int second;
    private int millisecond;
    private String inputFormat;
    private String outputFormat;
    private boolean leapYear;


    public Date(int day, Months month, int year, int hour, int minute, int second, int millisecond, String inputFormat, String outputFormat) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.millisecond = millisecond;
        this.inputFormat = inputFormat;
        this.outputFormat = outputFormat;
        this.leapYear = isLeapYear();
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Months getMonth() {
        return month;
    }

    public void setMonth(Months month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getMillisecond() {
        return millisecond;
    }

    public void setMillisecond(int millisecond) {
        this.millisecond = millisecond;
    }

    public String getInputFormat() {
        return inputFormat;
    }

    public void setInputFormat(String inputFormat) {
        this.inputFormat = inputFormat;
    }

    public String getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    private boolean isLeapYear() {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    @Override
    public String toString() {
        String[] dateFormat = isFormat();
        String delimeter = isDelimeter();
        String inputDate = "";

        for (int i = 0; i < dateFormat.length; i++) {
            if (i == 2) {
                inputDate += formatDate(dateFormat[i]);
            } else inputDate += formatDate(dateFormat[i]) + delimeter;
        }
        return inputDate;

    }

    private String isDelimeter() {
        Pattern pattern = Pattern.compile("[/|-]");
        Matcher matcher = pattern.matcher(outputFormat);
        String delimeter = "";

        while (matcher.find()) {
            delimeter = outputFormat.substring(matcher.start(), matcher.end());
        }
        return delimeter;
    }

    private String[] isFormat() {
        Pattern pattern = Pattern.compile("[/|-]");
        Matcher matcher = pattern.matcher(outputFormat);
        String delimeter = "";

        while (matcher.find()) {
            delimeter = outputFormat.substring(matcher.start(), matcher.end());
        }
        String[] date = outputFormat.split(delimeter);
        return date;
    }

    private String formatDate(String formatElement) {
        switch (formatElement) {
            case "d" -> {
                return "" + day;
            }
            case "dd" -> {
                if (day < 10) {
                    return "0" + day;
                } else {
                    return "" + day;
                }
            }
            case "m" -> {
                return "" + month.getIndex();
            }
            case "mm" -> {
                if (month.getIndex() < 10) {
                    return "0" + month.getIndex();
                } else {
                    return "" + month.getIndex();
                }
            }
            case "mmm" -> {
                return month.getName();
            }
            case "yyyy" -> {
                return "" + year;
            }
        }
        return "";
    }

}
