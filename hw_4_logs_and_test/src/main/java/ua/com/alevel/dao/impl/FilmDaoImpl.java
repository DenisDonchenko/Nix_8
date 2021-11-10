package ua.com.alevel.dao.impl;

import ua.com.alevel.dao.FilmDao;
import ua.com.alevel.db.impl.FilmDBImpl;
import ua.com.alevel.entity.Film;

public class FilmDaoImpl  implements FilmDao {
    @Override
    public void create(Film entity) {
        FilmDBImpl.getInstance().create(entity);
    }
    @Override
    public void update(Film entity) {
        FilmDBImpl.getInstance().update(entity);
    }

    @Override
    public void delete(Long id) {
        FilmDBImpl.getInstance().delete(id);
    }

    @Override
    public Film findById(Long id) {
        return FilmDBImpl.getInstance().findById(id);
    }

    @Override
    public Film[] findAll() {
        return FilmDBImpl.getInstance().findAll();
    }

    @Override
    public int count() {
        return 0;
    }
}
