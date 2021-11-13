package ua.com.alevel;

import ua.com.alevel.controller.FilmController;
import ua.com.alevel.controller.HallController;
import ua.com.alevel.controller.SessionController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProgrumRun {

    public void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        readmiPrint();
        run(reader);
    }

    public static void run(BufferedReader reader) {

        preview();
        String event;
        try {
            while ((event = reader.readLine()) != null) {
                switch (event) {
                    case "1" -> {
                        new HallController().run(reader);
                        isExit("1");
                    }
                    case "2" -> {
                        new FilmController().run(reader);
                        isExit("2");
                    }
                    case "3" -> {
                        new SessionController().run(reader);
                        isExit("3");
                    }
                    case "0" -> System.exit(0);

                    default -> run(reader);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readmiPrint() {
        System.out.println(" \nThis application for create sessions in cinema");
        System.out.println(" Have next entity: \n1)Hall \n2)Film \n3)Session");
        System.out.println("Hall ------> Session <------ Film");
        System.out.println("For create a session, you need to add a hall and films");
    }

    private static void preview() {
        System.out.println("\nGo to setting hall, select - 1");
        System.out.println("Go to setting film, select - 2");
        System.out.println("Go to setting session, select - 3");
        System.out.println("if you want exit, select - 0");
        System.out.println("Make your choice:");
    }

    public static void isExit(String numberTask) {
        System.out.println("\nIf you want continue, please select - " + numberTask +
                "\nIf you want exit to the main menu, please select enter.");
    }
}
