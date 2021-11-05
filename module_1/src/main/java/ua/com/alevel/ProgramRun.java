package ua.com.alevel;

import ua.com.alevel.move.horse.MoveHorse;
import ua.com.alevel.unique.symbol.UniqueNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProgramRun {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void run() {
        preview();
        String event;
        try {
            while ((event = reader.readLine()) != null) {
                switch (event) {
                    case "1": {
                        UniqueNumber.start(reader);
                        isExit("1");
                    }
                    break;
                    case "2": {
                        MoveHorse.run(reader);
                        isExit("2");
                    }
                    break;
                    case "3": {

                        isExit("3");
                    }
                    break;
                    case "0": {
                        System.exit(0);
                    }
                    break;
                    default: {
                        run();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void preview() {
        System.out.println("\nif you want get the number of unique characters, select - 1");
        System.out.println("If you want run application \"Horse movement\", select - 2");
        System.out.println("if you want exit, select - 0");
        System.out.println("Make your choice:");
    }

    public static void isExit(String numberTask) {
        System.out.println("\nIf you want continue, please select - " + numberTask +
                "\nIf you want exit to the main menu, please select enter.");
    }
}
