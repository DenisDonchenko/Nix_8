package ua.com.alevel.service.impl;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import ua.com.alevel.entity.Film;
import ua.com.alevel.service.FilmService;

import java.time.LocalTime;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FilmServiceImplTest {

    private static Film film = new Film();

    private static final Long FILM_ID = 1L;
    private static final String YEAR_USSUE = "2021";
    private static final LocalTime FILM_DURATION = LocalTime.parse("03:20");
    private static final String NAME_FILM = "Name Film 1";

    private final static FilmService filmService = new FilmServiceImpl();

    @Before
    public void setUp() {
        film = createTestFilm(NAME_FILM, YEAR_USSUE, FILM_DURATION);
    }

    @Test
    @Order(1)
    public void shouldDoReturnZeroPostListSizeIfPostListIsEmpte() {
        filmService.create(film);
        Assert.assertEquals(film, filmService.findById(FILM_ID));
    }
    @Test
    @Order(1)
    public void shouldAddFilm() {
        filmService.create(film);
        Assert.assertEquals(film, filmService.findById(FILM_ID));
    }

    @Test
    public void testUpdate() {
        Film filmForUpdate = new Film();

    }

    public void testDelete() {
    }

    public void testFindById() {
    }

    public void testFindAll() {
    }

    public void testExists() {
    }

    public void testCount() {
    }

    private Film createTestFilm(String nameFilm, String yearIssue, LocalTime filmDuration) {
        Film film = new Film();
        film.setId(FILM_ID);
        film.setFilmDuration(filmDuration);
        film.setNameFilm(nameFilm);
        film.setYearIssue(yearIssue);
        return film;
    }
}
