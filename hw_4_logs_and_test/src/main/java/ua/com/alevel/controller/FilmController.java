package ua.com.alevel.controller;

import ua.com.alevel.dto.film.CreateFilmDto;
import ua.com.alevel.dto.film.UpdateFilmDto;
import ua.com.alevel.entity.Film;
import ua.com.alevel.exception.film.InvalidFilmException;
import ua.com.alevel.facade.FilmFacade;
import ua.com.alevel.facade.impl.FilmFacadeImpl;
import ua.com.alevel.util.valide.Valide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class FilmController {

    private final FilmFacade filmFacade = new FilmFacadeImpl();

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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
        System.out.println("Create film, please enter 1;      Update film, please enter 2");
        System.out.println("Delete film, please enter 3;      Find film by id, please enter 4");
        System.out.println("Find all films, please enter 5;   Exit to main menu, please enter 0");
        System.out.println();
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1":
                create(reader);
                break;
            case "2":
                update(reader);
                break;
            case "3":
                delete(reader);
                break;
            case "4":
                findById(reader);
                break;
            case "5":
                findAll(reader);
                break;
        }
        runNavigation();
    }

    private void create(BufferedReader reader) {
        System.out.println("Create film");
        try {
            System.out.println("Please, enter name film");
            String nameFilm = reader.readLine();
            Valide.valideName(nameFilm);
            System.out.println("Please, enter film release year");
            String yearIssue = reader.readLine();
            Valide.valideYear(yearIssue);
            System.out.println("Please, enter film duration");
            String genre = reader.readLine();

            CreateFilmDto film = new CreateFilmDto(nameFilm, yearIssue, LocalTime.parse(genre));

            filmFacade.create(film);
        } catch (IOException|DateTimeParseException e) {
            System.out.println("Exception input time !!!");
            create(reader);
        }
        catch (InvalidFilmException exception){
            System.out.println(exception.getMessage());
            create(reader);
        }
    }

    private void update(BufferedReader reader) {
        System.out.println("Update Film");
        try {
            System.out.println("Please, enter id");
            Long id = Long.valueOf(reader.readLine());
            System.out.println("Please, enter name film");
            String nameFilm = reader.readLine();
            Valide.valideName(nameFilm);
            System.out.println("Please, enter film release year");
            String yearIssue = reader.readLine();
            Valide.valideYear(yearIssue);
            System.out.println("Please, enter film duration");
            String genre = reader.readLine();

            UpdateFilmDto film = new UpdateFilmDto(id, nameFilm, yearIssue, LocalTime.parse(genre));
            filmFacade.update(film);
        } catch (IOException|DateTimeParseException e) {
            System.out.println("Exception input !!!");
            update(reader);
        }
    }

    private void delete(BufferedReader reader) {
        System.out.println("Delete Film");
        try {
            System.out.println("Please, enter id film");
            Long id = Long.valueOf(reader.readLine());
            filmFacade.delete(id);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findById(BufferedReader reader) {
        System.out.println("Find film by id");
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
        System.out.println("UserController.findAll");

        Film[] films = filmFacade.findAll();
        for (Film film : films) {
            System.out.println(film.toString());
        }
    }
}
