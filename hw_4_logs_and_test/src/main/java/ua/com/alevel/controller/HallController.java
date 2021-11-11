package ua.com.alevel.controller;

import ua.com.alevel.ProgrumRun;
import ua.com.alevel.dto.hall.HallCreateDto;
import ua.com.alevel.dto.hall.HallUpdateDto;
import ua.com.alevel.entity.Hall;
import ua.com.alevel.exception.film.InvalidFilmException;
import ua.com.alevel.facade.HallFacade;
import ua.com.alevel.facade.impl.HallFacadeImpl;
import ua.com.alevel.util.valide.ValidHall;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.format.DateTimeParseException;

public class HallController {

    private final HallFacade hallFacade = new HallFacadeImpl();

    public void run(BufferedReader reader) {
        System.out.println("select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("------------------------------HALL--------------------------------------");
        System.out.println("Create hall, please enter 1;      Update hall, please enter 2");
        System.out.println("Delete hall, please enter 3;      Find hall by id, please enter 4");
        System.out.println("Find all halls, please enter 5;   Exit to main menu, please enter 0");
        System.out.println("------------------------------------------------------------------------");
        System.out.println();
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1":
                System.out.println("                      Create film                               ");
                create(reader);
                break;
            case "2":
                System.out.println("                      Update film                               ");
                update(reader);
                break;
            case "3":
                System.out.println("                      Delete film                               ");
                delete(reader);
                break;
            case "4":
                System.out.println("                      Find by id hall                               ");
                findById(reader);
                break;
            case "5":
                System.out.println("                      Find all halls                               ");
                findAll(reader);
                break;
            case "0":
                ProgrumRun.run();
                break;
        }
        runNavigation();
    }

    private void create(BufferedReader reader) {

        try {
            System.out.println("Please, enter name hall ");
            String nameHall = reader.readLine();
            ValidHall.validName(nameHall);
            System.out.println("Please, hall capacity ");
            int capacity = Integer.parseInt(reader.readLine());
            ValidHall.validCapacity(String.valueOf(capacity));

            hallFacade.create(new HallCreateDto(nameHall, capacity));
        } catch (IOException | InvalidFilmException exception) {
            System.out.println(exception.getMessage());
            create(reader);
        }
    }

    private void update(BufferedReader reader) {

        try {
            System.out.println("Please, enter id");
            Long id = Long.valueOf(reader.readLine());
            System.out.println("Please, enter name hall ");
            String nameHall = reader.readLine();
            ValidHall.validName(nameHall);
            System.out.println("Please, hall capacity ");
            int capacity = Integer.parseInt(reader.readLine());
            ValidHall.validCapacity(String.valueOf(capacity));

            hallFacade.update(new HallUpdateDto(id, nameHall, capacity));
        } catch (IOException | DateTimeParseException e) {
            System.out.println("Exception input !!!");
            update(reader);
        }
    }

    private void delete(BufferedReader reader) {

        try {
            System.out.println("Please, enter id hall");
            Long id = Long.valueOf(reader.readLine());
            hallFacade.delete(id);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findById(BufferedReader reader) {

        try {
            System.out.println("Please, enter id hall");
            Long id = Long.valueOf(reader.readLine());
            Hall hall = hallFacade.findById(id);
            System.out.println(hall.toString());
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findAll(BufferedReader reader) {
        Hall[] halls = hallFacade.findAll();
        for (Hall hall : halls) {
            System.out.println(hall.toString());
        }
    }
}
