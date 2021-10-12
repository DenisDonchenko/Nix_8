package ua.com.alevel.endLessons;

import java.io.BufferedReader;
import java.io.IOException;

public class EndLessons {
    private int numberLesson = 0;
    private int hour;
    private int minute;

    public void run(BufferedReader reader) throws IOException {
        readString(reader);
    }

    private void endTime() {
        numberLesson = numberLesson * 45 + (numberLesson / 2) * 5 + ((numberLesson + 1) / 2 - 1);
        hour = numberLesson / 60 + 9;
        minute = numberLesson % 60;
        System.out.println(hour + ":" + minute);
    }

    private void readString(BufferedReader reader) throws IOException {
        try {
            System.out.println("\n This task takes lesson number and determines when the specified lesson ends." +
                    "\n Enter number lessons");
            numberLesson = Integer.parseInt(reader.readLine());

            if (numberLesson > 10 || numberLesson < 1) {
                throw new Exception();
            }
            endTime();
        } catch (NumberFormatException e) {
            System.out.println("Input Error. Enter not a number");
            readString(reader);
           } catch (Exception e) {
            System.out.println("Input Error. Please enter a number from 1 to 10");
            readString(reader);
        }
    }
}
