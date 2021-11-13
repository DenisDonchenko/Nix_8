package ua.com.alevel.controller;

import ua.com.alevel.ProgrumRun;
import ua.com.alevel.dto.sessions.SessionCreateDto;
import ua.com.alevel.dto.sessions.SessionFindDto;
import ua.com.alevel.dto.sessions.SessionUpdateDto;
import ua.com.alevel.facade.SessionFacade;
import ua.com.alevel.facade.impl.SessionFacadeImpl;
import ua.com.alevel.util.ConstGlobal;
import ua.com.alevel.util.valide.ValidSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class SessionController {

    private final SessionFacade sessionFacade = new SessionFacadeImpl();

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
        System.out.println("------------------------------SESSION----------------------------------");
        System.out.println("Create session, please enter 1;      Update session, please enter 2");
        System.out.println("Delete session, please enter 3;      Find session by id, please enter 4");
        System.out.println("Find all session, please enter 5;    Exit to main menu, please enter 6");
        System.out.println("------------------------------------------------------------------------");
        System.out.println();
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1" -> {
                System.out.println("                      Session film                               ");
                create(reader);
            }
            case "2" -> {
                System.out.println("                      Session film                               ");
                update(reader);
            }
            case "3" -> {
                System.out.println("                      Session film                               ");
                delete(reader);
            }
            case "4" -> {
                System.out.println("                      Find by id Session                               ");
                findById(reader);
            }
            case "5" -> {
                System.out.println("                      Find all Sessions                               ");
                findAll();
            }
            case "6" -> ProgrumRun.run(reader);
        }
        runNavigation();
    }

    private void create(BufferedReader reader) {
        try {
            System.out.println("Enter id film");
            Long idFilm = readId(reader);
            System.out.println("Enter id hall");
            Long idHall = readId(reader);

            LocalDate dateSession = readDateSession(reader);
            LocalTime timeStart = readStartTimeSession(reader);

            sessionFacade.create(new SessionCreateDto(idFilm, idHall, dateSession, timeStart));
        } catch (IOException | DateTimeParseException e) {
            create(reader);
        }
    }


    private void update(BufferedReader reader) {
        try {
            System.out.println("Enter id session");
            Long idSession = readId(reader);

            System.out.println("Enter id film");
            Long idFilm = readId(reader);
            System.out.println("Enter id hall");
            Long idHall = readId(reader);

            LocalDate dateSession = readDateSession(reader);
            LocalTime timeStart = readStartTimeSession(reader);

            sessionFacade.update(new SessionUpdateDto(idSession, idFilm, idHall, dateSession, timeStart));
        } catch (IOException e) {
            update(reader);
        }
    }

    private void delete(BufferedReader reader) {
        try {
            System.out.println("Enter id session");
            Long idSession = readId(reader);
            sessionFacade.delete(idSession);
        } catch (IOException e) {
            delete(reader);
        }
    }

    private void findById(BufferedReader reader) {
        try {
            System.out.println("Enter id session");
            Long idSession = readId(reader);
            System.out.println(sessionFacade.findById(idSession).toString());
        } catch (IOException e) {
            findById(reader);
        }
    }

    private void findAll() {
        SessionFindDto[] dtos = sessionFacade.findAll();

        for (SessionFindDto dto : dtos) {
            System.out.println(dto.toString());
        }

    }

    private LocalDate readDateSession(BufferedReader reader) throws IOException {
        System.out.println("Please, date session");
        String dateSession = reader.readLine();
        if (!ValidSession.validDate(dateSession)) {
            throw new IOException();
        }

        return LocalDate.parse(dateSession, ConstGlobal.DATE_FORMATTER);
    }

    private LocalTime readStartTimeSession(BufferedReader reader) throws IOException {
        System.out.println("Enter time start session");
        String timeStart = reader.readLine();
        if (!ValidSession.validTime(timeStart, "session.time.empty", "session.time.format")) {
            throw new IOException();
        }

        return LocalTime.parse(timeStart);
    }

    private Long readId(BufferedReader reader) throws IOException {
        /*System.out.println("Please, enter id session");*/
        String id = reader.readLine();
        if (!ValidSession.validIdEntity(id)) {
            throw new IOException();
        }
        return Long.parseLong(id);
    }


}
