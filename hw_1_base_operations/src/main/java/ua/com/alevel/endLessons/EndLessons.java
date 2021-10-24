package ua.com.alevel.endLessons;

import ua.com.alevel.ProgramRun;

import java.io.BufferedReader;

public class EndLessons {

    private int numberLesson = 0;
    private int hour;
    private int minute;
    private BufferedReader reader;

    public EndLessons(BufferedReader reader) {
        this.reader = reader;
    }

    public void run() {
        readString();
    }

    private void endTime() {
        numberLesson = numberLesson * 45 + (numberLesson / 2) * 5 + ((numberLesson + 1) / 2 - 1);
        hour = numberLesson / 60 + 9;
        minute = numberLesson % 60;
        System.out.println(hour + ":" + minute);
        ProgramRun.isExit("3");
    }

    private void readString() {
        try {
            System.out.println("\nThis task takes lesson number and determines when the specified lesson ends." +
                    "\nEnter number lessons");
            numberLesson = Integer.parseInt(reader.readLine());

            if (numberLesson > 10 || numberLesson < 1) {
                throw new Exception();
            }
            endTime();
        } catch (NumberFormatException e) {
            System.out.println("Input Error. Enter not a number");
            ProgramRun.isExit("3");
        } catch (Exception e) {
            System.out.println("Input Error. Please enter a number from 1 to 10");
            ProgramRun.isExit("3");
        }
    }
}
