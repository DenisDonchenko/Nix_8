package ua.com.alevel;

import ua.com.alevel.sumNumbers.SumNumbersFromString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProgramRun {
    public static void run() {
        preview();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String event;
        try {
            while ((event = reader.readLine()) != null) {
                switch (event) {
                    case "1" : {

                    } break;
                    case "2" : {

                    } break;
                    case "3" : {

                    } break;
                    case "0" : {
                        System.exit(0);
                    } break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void preview() {
        System.out.println("if you want run first task, please select 1");
        System.out.println("if you want run second task, please select 2");
        System.out.println("if you want run second task, please select 3");
        System.out.println("if you want run exit task, please select 0");
        System.out.println("Make your choice:");
        System.out.println();
    }
}
