package ua.com.alevel.service.impl;

import ua.com.alevel.dao.FilmDao;
import ua.com.alevel.dao.impl.FilmDaoImpl;
import ua.com.alevel.entity.Film;
import ua.com.alevel.service.FilmService;
import ua.com.alevel.util.ConstGlobal;

public class FilmServiceImpl implements FilmService {

    private final FilmDao filmDao = new FilmDaoImpl();

    @Override
    public void create(Film entity) {
        ConstGlobal.loggerInfo.info(ConstGlobal.settings.getString("film.create") + entity.toString());
        filmDao.create(entity);
    }

    @Override
    public void update(Film entity) {
        ConstGlobal.loggerInfo.info(ConstGlobal.settings.getString("film.update") + entity.toString());
        filmDao.update(entity);
    }

    @Override
    public void delete(Long id) {
        ConstGlobal.loggerInfo.info(ConstGlobal.settings.getString("film.delete") + id);
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

    @Override
    public boolean exists(Long id) {
        return filmDao.exists(id);
    }

    @Override
    public int count() {
        return filmDao.count();
    }
}
