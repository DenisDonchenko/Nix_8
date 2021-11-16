package ua.com.alevel.controller;

import ua.com.alevel.ProgrumRun;
import ua.com.alevel.dto.film.CreateFilmDto;
import ua.com.alevel.dto.film.UpdateFilmDto;
import ua.com.alevel.entity.Film;
import ua.com.alevel.facade.FilmFacade;
import ua.com.alevel.facade.impl.FilmFacadeImpl;
import ua.com.alevel.util.valide.ValidFilm;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class FilmController {

    private final FilmFacade filmFacade = new FilmFacadeImpl();

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
        System.out.println("---------------------------FILM------------------------------------");
        System.out.println("                     Select your option                             ");
        System.out.println("Create film, please enter 1;      Update film, please enter 2");
        System.out.println("Delete film, please enter 3;      Find film by id, please enter 4");
        System.out.println("Find all films, please enter 5;   Exit to main menu, please enter 6");
        System.out.println("------------------------------------------------------------------------");
        System.out.println();
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1" -> {
                System.out.println("                      Create film                               ");
                create(reader);
            }
            case "2" -> {
                System.out.println("                      Update film                               ");
                update(reader);
            }
            case "3" -> {
                System.out.println("                      Delete film                               ");
                delete(reader);
            }
            case "4" -> {
                System.out.println("                      Find by id film                               ");
                findById(reader);
            }
            case "5" -> {
                System.out.println("                      Find all films                               ");
                findAll(reader);
            }
            case "6" -> ProgrumRun.run(reader);
        }
        runNavigation();
    }

    private void create(BufferedReader reader) {
        try {
            String nameFilm = readNameFilm(reader);
            String yearIssue = readYearIssue(reader);
            LocalTime filmDuration = readFilmDuration(reader);

            filmFacade.create(new CreateFilmDto(nameFilm, yearIssue, filmDuration));
        } catch (IOException | DateTimeParseException e) {
            create(reader);
        }
    }


    private void update(BufferedReader reader) {
        try {
            Long id = readIdFilm(reader);
            String nameFilm = readNameFilm(reader);
            String yearIssue = readYearIssue(reader);
            LocalTime filmDuration = readFilmDuration(reader);

            filmFacade.update(new UpdateFilmDto(id, nameFilm, yearIssue, filmDuration));
        } catch (IOException e) {
            run(reader);
        }
    }

    private void delete(BufferedReader reader) {
        try {
            Long id = readIdFilm(reader);
            filmFacade.delete(id);
        } catch (IOException e) {
            run(reader);
        }
    }

    private void findById(BufferedReader reader) {
        try {
            Long id = readIdFilm(reader);
            System.out.println(filmFacade.findById(id).toString());
        } catch (IOException e) {
            run(reader);
        }
    }

    private void findAll(BufferedReader reader) {
        try {
            for (Film film : filmFacade.findAll()) {
                System.out.println(film.toString());
            }
        } catch (IOException e) {
            run(reader);
        }
    }

    private LocalTime readFilmDuration(BufferedReader reader) throws IOException {
        System.out.println("Please, enter film duration (format input -  HH:mm)");
        String filmDuration = reader.readLine();

        if (!ValidFilm.validTime(filmDuration, "film.duration.empty", "film.duration.format")) {
            throw new IOException();
        }
        return LocalTime.parse(filmDuration);
    }

    private String readYearIssue(BufferedReader reader) throws IOException {
        System.out.println("Please, enter film release year (format input -  yyyy)");
        String yearIssue = reader.readLine();

        if (!ValidFilm.validYear(yearIssue)) {
            throw new IOException();
        }
        return yearIssue;
    }

    private String readNameFilm(BufferedReader reader) throws IOException {
        System.out.println("Please, enter name film");
        String nameFilm = reader.readLine();

        if (!ValidFilm.validName(nameFilm, "film.name.empty")) {
            throw new IOException();
        }
        return nameFilm;
    }

    private Long readIdFilm(BufferedReader reader) throws IOException {
        System.out.println("Please, enter id");
        String id = reader.readLine();

        if (!ValidFilm.validIdEntity(id)) {
            throw new IOException();
        }
        return Long.parseLong(id);
    }

}
