package ua.com.alevel.facade;

import ua.com.alevel.dto.film.CreateFilmDto;
import ua.com.alevel.dto.film.UpdateFilmDto;
import ua.com.alevel.entity.Film;

public interface FilmFacade {

    void create(CreateFilmDto entity);

    void update(UpdateFilmDto entity);

    void delete(Long id);

    Film findById(Long id);

    Film[] findAll();
}
