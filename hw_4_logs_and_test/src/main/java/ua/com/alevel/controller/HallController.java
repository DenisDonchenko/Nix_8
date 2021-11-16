package ua.com.alevel.controller;

import ua.com.alevel.ProgrumRun;
import ua.com.alevel.dto.hall.HallCreateDto;
import ua.com.alevel.dto.hall.HallUpdateDto;
import ua.com.alevel.entity.Hall;
import ua.com.alevel.facade.HallFacade;
import ua.com.alevel.facade.impl.HallFacadeImpl;
import ua.com.alevel.util.valide.ValidFilm;
import ua.com.alevel.util.valide.ValidHall;

import java.io.BufferedReader;
import java.io.IOException;

public class HallController {

    private final HallFacade hallFacade = new HallFacadeImpl();

    public void run(BufferedReader reader) {
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
        System.out.println("---------------------------HALL------------------------------------");
        System.out.println("                     Select your option                             ");
        System.out.println("Create hall, please enter 1;      Update hall, please enter 2");
        System.out.println("Delete hall, please enter 3;      Find hall by id, please enter 4");
        System.out.println("Find all halls, please enter 5;   Exit to main menu, please enter 6");
        System.out.println("------------------------------------------------------------------------");
        System.out.println();
    }

    private void crud(String position, BufferedReader reader) {

        switch (position) {
            case "1" -> {
                System.out.println("                      Create hall                               ");
                create(reader);
            }
            case "2" -> {
                System.out.println("                      Update hall                               ");
                update(reader);
            }
            case "3" -> {
                System.out.println("                      Delete hall                               ");
                delete(reader);
            }
            case "4" -> {
                System.out.println("                      Find by id hall                               ");
                findById(reader);
            }
            case "5" -> {
                System.out.println("                      Find all halls                               ");
                findAll(reader);
            }
            case "6" -> ProgrumRun.run(reader);
        }
        runNavigation();
    }

    private void create(BufferedReader reader) {
        try {
            String nameHall = readHallName(reader);
            int capacity = readCapacityHall(reader);

            hallFacade.create(new HallCreateDto(nameHall, capacity));
        } catch (IOException e) {
            create(reader);
        }
    }

    private void update(BufferedReader reader) {
        try {
            Long id = readId(reader);
            String nameHall = readHallName(reader);
            int capacity = readCapacityHall(reader);
            hallFacade.update(new HallUpdateDto(id, nameHall, capacity));
        } catch (IOException e) {
            run(reader);
        }
    }

    private void delete(BufferedReader reader) {
        try {
            Long id = readId(reader);
            hallFacade.delete(id);
        } catch (IOException e) {
            run(reader);
        }
    }


    private void findById(BufferedReader reader) {
        try {
            Long id = readId(reader);
            System.out.println(hallFacade.findById(id).toString());
        } catch (IOException e) {
            run(reader);
        }
    }

    private void findAll(BufferedReader reader) {
        try {
            for (Hall hall : hallFacade.findAll()) {
                System.out.println(hall.toString());
            }
        } catch (IOException e) {
            run(reader);
        }
    }

    private Long readId(BufferedReader reader) throws IOException {
        System.out.println("Please, enter id hall");
        String id = reader.readLine();

        if (!ValidFilm.validIdEntity(id)) {
            throw new IOException();
        }
        return Long.parseLong(id);
    }

    private String readHallName(BufferedReader reader) throws IOException {
        System.out.println("Please, enter name hall");
        String nameHall = reader.readLine();

        if (!ValidHall.validName(nameHall, "hall.name.empty")) {
            throw new IOException();
        }
        return nameHall;
    }

    private int readCapacityHall(BufferedReader reader) throws IOException {
        System.out.println("Please, enter the capacity of the hall");
        String capacityHall = reader.readLine();

        if (!ValidHall.validCapacity(capacityHall)) {
            throw new IOException();
        }
        return Integer.parseInt(capacityHall);
    }
}
