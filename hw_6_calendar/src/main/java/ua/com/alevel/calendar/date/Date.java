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
        this.leapYear = isLeapYear();
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

    public boolean isLeapYear() {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    @Override
    public String toString() {

        String[] dateTime;
        String delimeter = "";
        String[] dateFormat;
        String[] timeFormat = new String[0];
        String time = " ";
        String inputDate = "";

        if (outputFormat.contains(":")) {
            dateTime = outputFormat.trim().split(" ");
            delimeter = isDelimeter(dateTime[0]);
            dateFormat = isFormat(delimeter, dateTime[0]);
            timeFormat = dateTime[1].trim().split(":");
            time += formatTime(timeFormat);
        } else {
            delimeter = isDelimeter(outputFormat);
            dateFormat = isFormat(delimeter, outputFormat);
        }

        if (outputFormat.contains("mmm")) {
            for (int i = 0; i < dateFormat.length; i++) {
                inputDate += formatDate(dateFormat[i]) + " ";
            }
        } else {
            for (int i = 0; i < dateFormat.length; i++) {
                if (i == 2) {
                    inputDate += formatDate(dateFormat[i]);
                } else inputDate += formatDate(dateFormat[i]) + delimeter;
            }
        }
        inputDate += time;
        return inputDate;
    }

    private String isDelimeter(String dateTimeFormat) {
        Pattern pattern = Pattern.compile("[/|-]");
        Matcher matcher = pattern.matcher(dateTimeFormat);
        String delimeter = "";

        while (matcher.find()) {
            delimeter = dateTimeFormat.substring(matcher.start(), matcher.end());
        }
        return delimeter;
    }

    private String[] isFormat(String delimeter, String outputFormatDate) {
        Pattern pattern = Pattern.compile("[/|-]");
        Matcher matcher = pattern.matcher(outputFormatDate);

        String[] date = outputFormatDate.split(delimeter);
        return date;
    }


    private String formatTime(String[] formatElement) {
        String timeString = "";
        String hourString = "";
        String minuteString = "";
        String secondString = "";
        String millisecondString = "";

        int lengthTime = formatElement.length;

        if (hour < 10) {
            hourString += "0" + hour;
        } else hourString += "" + hour;
        timeString += hourString + ":";
        if (minute < 10) {
            minuteString += "0" + minute;
        } else minuteString += "" + minute;
        timeString += minuteString;

        if (lengthTime == 3) {
            if (second < 10) {
                secondString += "0" + second;
            } else secondString += "" + second;
            timeString += ":" + secondString;
        }
        if (lengthTime == 4) {
            if (second < 10) {
                secondString += "0" + second;
            } else secondString += "" + second;
            timeString += ":" + secondString;
            if (formatElement[3].contains("00")) {
                if (millisecond < 10) {
                    millisecondString += "0" + millisecond;
                } else millisecondString += "" + millisecond;
            }
           /* if (formatElement[3].contains("000")) {
                if (millisecond < 10) {
                    millisecondString += "0" + millisecond;
                } else millisecondString += "" + millisecond;
            }*/
            timeString += ":" + millisecondString;
        }
        return timeString;
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
