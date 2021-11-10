package ua.com.alevel.service.impl;

import ua.com.alevel.dao.FilmDao;
import ua.com.alevel.dao.impl.FilmDaoImpl;
import ua.com.alevel.entity.Film;
import ua.com.alevel.service.FilmService;

public class FilmServiceImpl implements FilmService {

    private final FilmDao filmDao = new FilmDaoImpl();

    @Override
    public void create(Film entity) {
        filmDao.create(entity);
    }

    @Override
    public void update(Film entity) {
        filmDao.update(entity);
    }

    @Override
    public void delete(Long id) {
        filmDao.delete(id);
    }

    @Override
    public Film findById(Long id) {
        return filmDao.findById(id);
    }

    @Override
    public Film[] findAll() {
        return filmDao.findAll();
    }
}
