package ua.com.alevel.facade.impl;

import ua.com.alevel.dto.film.CreateFilmDto;
import ua.com.alevel.dto.film.UpdateFilmDto;
import ua.com.alevel.dto.sessions.SessionDto;
import ua.com.alevel.entity.Film;
import ua.com.alevel.entity.Session;
import ua.com.alevel.facade.FilmFacade;
import ua.com.alevel.facade.SessionFacade;
import ua.com.alevel.service.FilmService;
import ua.com.alevel.service.impl.FilmServiceImpl;

import java.time.LocalTime;

public class FilmFacadeImpl implements FilmFacade {
    private static FilmService filmService = new FilmServiceImpl();

    @Override
    public void create(CreateFilmDto entity) {
        Film film = createFilm(entity);
        filmService.create(film);
    }

    @Override
    public void update(UpdateFilmDto entity) {
        Film film = updateFilm(entity);
        filmService.update(film);
    }

    @Override
    public void delete(Long id) {
        filmService.delete(id);
    }

    @Override
    public Film findById(Long id) {
        return filmService.findById(id);
    }

    @Override
    public Film[] findAll() {
        return filmService.findAll();
    }

    private Film createFilm(CreateFilmDto createFilmDto) {
        String nameFilm = createFilmDto.getNameFilm();
        String yearIssue = createFilmDto.getYearIssue();
        LocalTime genre = createFilmDto.getGenre();

        return new Film(nameFilm, yearIssue, genre);
    }

    private Film updateFilm(UpdateFilmDto updateFilmDto) {

        Film filmFromDB = filmService.findById(updateFilmDto.getId());

        filmFromDB.setNameFilm(updateFilmDto.getNameFilm());
        filmFromDB.setYearIssue(updateFilmDto.getYearIssue());
        filmFromDB.setGenre(updateFilmDto.getGenre());
        return filmFromDB;
    }

}
