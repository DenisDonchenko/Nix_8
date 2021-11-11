package ua.com.alevel.controller;

import ua.com.alevel.ProgrumRun;
import ua.com.alevel.dto.film.CreateFilmDto;
import ua.com.alevel.dto.film.UpdateFilmDto;
import ua.com.alevel.entity.Film;
import ua.com.alevel.exception.film.InvalidFilmException;
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
        System.out.println("---------------------------FILM------------------------------------");
        System.out.println("Create film, please enter 1;      Update film, please enter 2");
        System.out.println("Delete film, please enter 3;      Find film by id, please enter 4");
        System.out.println("Find all films, please enter 5;   Exit to main menu, please enter 0");
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
            System.out.println("Please, enter name film");
            String nameFilm = reader.readLine();
            ValidFilm.validName(nameFilm);
            System.out.println("Please, enter film release year");
            String yearIssue = reader.readLine();
            ValidFilm.validYear(yearIssue);
            System.out.println("Please, enter film duration");
            String genre = reader.readLine();

            filmFacade.create(new CreateFilmDto(nameFilm, yearIssue, LocalTime.parse(genre)));
        } catch (IOException | DateTimeParseException e) {
            System.out.println("Exception input !!!");
            create(reader);
        } catch (InvalidFilmException exception) {
            System.out.println(exception.getMessage());
            create(reader);
        }
    }

    private void update(BufferedReader reader) {
        try {
            System.out.println("Please, enter id");
            Long id = Long.valueOf(reader.readLine());
            System.out.println("Please, enter name film");
            String nameFilm = reader.readLine();
            ValidFilm.validName(nameFilm);
            System.out.println("Please, enter film release year");
            String yearIssue = reader.readLine();
            ValidFilm.validYear(yearIssue);
            System.out.println("Please, enter film duration");
            String genre = reader.readLine();

            filmFacade.update(new UpdateFilmDto(id, nameFilm, yearIssue, LocalTime.parse(genre)));
        } catch (IOException | DateTimeParseException e) {
            System.out.println("Exception input !!!");
            update(reader);
        } catch (InvalidFilmException exception) {
            System.out.println(exception.getMessage());
            update(reader);
        }
    }

    private void delete(BufferedReader reader) {
        try {
            System.out.println("Please, enter id film");
            Long id = Long.valueOf(reader.readLine());
            filmFacade.delete(id);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findById(BufferedReader reader) {
        try {
            System.out.println("Please, enter id film");
            Long id = Long.valueOf(reader.readLine());
            Film film = filmFacade.findById(id);
            System.out.println(film.toString());
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findAll(BufferedReader reader) {
        Film[] films = filmFacade.findAll();
        for (Film film : films) {
            System.out.println(film.toString());
        }
    }
}
