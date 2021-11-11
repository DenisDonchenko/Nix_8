package ua.com.alevel;

import ua.com.alevel.controller.FilmController;
import ua.com.alevel.controller.HallController;
import ua.com.alevel.entity.Hall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProgrumRun {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void run() {
        preview();
        String event;
        try {
            while ((event = reader.readLine()) != null) {
                switch (event) {
                    case "1": {
                        new HallController().run(reader);
                        isExit("1");
                    }
                    break;
                    case "2": {
                        new FilmController().run(reader);
                        isExit("2");
                    }
                    break;
                    case "3": {
                        isExit("3");
                    }
                    case "4": {

                        isExit("4");
                    }
                    case "5": {
                        isExit("5");
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
        System.out.println("\nGo to setting hall, select - 1");
        System.out.println("Go to setting film, select - 2");
        System.out.println("if you want exit, select - 0");
        System.out.println("Make your choice:");
    }
    public static void isExit(String numberTask) {
        System.out.println("\nIf you want continue, please select - " + numberTask +
                "\nIf you want exit to the main menu, please select enter.");
    }
}
