package ua.com.alevel.facade.impl;

import ua.com.alevel.dto.film.CreateFilmDto;
import ua.com.alevel.dto.film.UpdateFilmDto;
import ua.com.alevel.entity.Film;
import ua.com.alevel.facade.FilmFacade;
import ua.com.alevel.service.FilmService;
import ua.com.alevel.service.SessionService;
import ua.com.alevel.service.impl.FilmServiceImpl;
import ua.com.alevel.service.impl.SessionServiceImpl;
import ua.com.alevel.util.ConstGlobal;

import java.io.IOException;
import java.time.LocalTime;

public class FilmFacadeImpl implements FilmFacade {
    private static final FilmService filmService = new FilmServiceImpl();
    private final SessionService sessionService = new SessionServiceImpl();

    @Override
    public void create(CreateFilmDto entity) {
        Film film = createFilm(entity);
        filmService.create(film);
    }

    @Override
    public void update(UpdateFilmDto updateFilmDto) throws IOException {
        if (!exists(updateFilmDto.getId())) {
            System.out.println(ConstGlobal.settings.getString("film.id.not.found") + " " + updateFilmDto.getId());
            ConstGlobal.loggerWarn.warn(ConstGlobal.settings.getString("film.id.not.found") + " " + updateFilmDto.getId());
            throw new IOException();
        } else {
            Film film = updateFilm(updateFilmDto);
            filmService.update(film);
        }
    }

    @Override
    public void delete(Long id) throws IOException {
        if (existsFilmInSession(id)) {
            System.out.println(ConstGlobal.settings.getString("film.used.session"));
            ConstGlobal.loggerWarn.warn(ConstGlobal.settings.getString("film.not.delete") + id);
            throw new IOException();
        } else if (!exists(id)) {
            System.out.println(ConstGlobal.settings.getString("film.id.not.found") + " " + id);
            ConstGlobal.loggerWarn.warn(ConstGlobal.settings.getString("film.id.not.found") + " " + id);
            throw new IOException();
        } else
            filmService.delete(id);
    }

    @Override
    public Film findById(Long id) throws IOException {
        if (!exists(id)) {
            System.out.println(ConstGlobal.settings.getString("film.id.not.found") + " " + id);
            ConstGlobal.loggerWarn.warn(ConstGlobal.settings.getString("film.id.not.found") + " " + id);
            throw new IOException();
        } else {
            ConstGlobal.loggerInfo.info(ConstGlobal.settings.getString("film.find.by.id") + id);
            return filmService.findById(id);
        }
    }

    @Override
    public Film[] findAll() throws IOException {
        if (filmService.count() == 0) {
            System.out.println(ConstGlobal.settings.getString("film.does.not.exist"));
            ConstGlobal.loggerWarn.warn(ConstGlobal.settings.getString("film.does.not.exist"));
            throw new IOException();
        } else {
            return filmService.findAll();
        }
    }

    @Override
    public boolean exists(Long id) {
        return filmService.exists(id);
    }

    @Override
    public boolean existsFilmInSession(Long id) {
        return sessionService.existsFilmInSession(id);
    }


    private Film createFilm(CreateFilmDto createFilmDto) {
        String nameFilm = createFilmDto.getNameFilm();
        String yearIssue = createFilmDto.getYearIssue();
        LocalTime filmDuration = createFilmDto.getFilmDuration();

        return new Film(nameFilm, yearIssue, filmDuration);
    }

    private Film updateFilm(UpdateFilmDto updateFilmDto) {
        Film filmFromDB = filmService.findById(updateFilmDto.getId());

        filmFromDB.setNameFilm(updateFilmDto.getNameFilm());
        filmFromDB.setYearIssue(updateFilmDto.getYearIssue());
        filmFromDB.setFilmDuration(updateFilmDto.getFilmDuration());
        return filmFromDB;
    }
}
