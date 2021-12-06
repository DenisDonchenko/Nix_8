package ua.com.alevel.calendar;

public interface BaseCalendar {
    String getDate();

    void editFormatOutput(String outputFormat);

    void editFormatInput(String inputFormat);

    int lengthMonth();

    void plusYears(int yearsToAdd);

    void minusYears(int yearsToRemove);

    void plusMonths(int monthsToAdd);

    void minusMonths(int monthsToRemove);

    void plusDays(int daysToAdd);

    void minusDays(int daysToRemove);

    void plusHours(int hoursToAdd);

    void minusHours(int hoursToRemove);

    void plusMinutes(int minutesToAdd);

    void minusMinutes(int minutesToRemove);

    void plusSeconds(int secondsToAdd);

    void minusSeconds(int secondsToRemove);

}
