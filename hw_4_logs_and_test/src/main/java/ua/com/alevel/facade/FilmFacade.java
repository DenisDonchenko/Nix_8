package ua.com.alevel.facade;

import ua.com.alevel.dto.film.CreateFilmDto;
import ua.com.alevel.dto.film.UpdateFilmDto;
import ua.com.alevel.entity.Film;

import java.io.IOException;

public interface FilmFacade {

    void create(CreateFilmDto entity);

    void update(UpdateFilmDto entity) throws IOException;

    void delete(Long id) throws IOException;

    Film findById(Long id) throws IOException;

    Film[] findAll() throws IOException;

    boolean exists(Long id);

    boolean existsFilmInSession(Long id);
}
