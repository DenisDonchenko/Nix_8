package ua.com.alevel;

import ua.com.alevel.area.triangle.AreaTriangle;
import ua.com.alevel.move.horse.MoveHorse;
import ua.com.alevel.unique.symbol.UniqueNumber;
import ua.com.alevel.valide.brackets.Brackets;

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
                      new UniqueNumber(reader).run();
                        isExit("1");
                    }
                    break;
                    case "2": {
                       new MoveHorse(reader).run();
                        isExit("2");
                    }
                    break;
                    case "3": {
                       new AreaTriangle(reader).start();
                        isExit("3");
                    }
                    case "4": {
                        new Brackets(reader).start();
                        isExit("4");
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
        System.out.println("\nIf you want run application \"Unique numbers\", select - 1");
        System.out.println("If you want run application \"Horse movement\", select - 2");
        System.out.println("If you want run application \"Area triangle\", select - 3");
        System.out.println("If you want run application \"Bracket valid\", select - 4");
        System.out.println("if you want exit, select - 0");
        System.out.println("Make your choice:");
    }

    public static void isExit(String numberTask) {
        System.out.println("\nIf you want continue, please select - " + numberTask +
                "\nIf you want exit to the main menu, please select enter.");
    }
}
