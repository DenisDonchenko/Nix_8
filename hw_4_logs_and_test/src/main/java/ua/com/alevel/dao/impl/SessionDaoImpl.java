package ua.com.alevel.dao.impl;

import ua.com.alevel.dao.SessionDao;
import ua.com.alevel.db.impl.HallDBImpl;
import ua.com.alevel.db.impl.SessionDBImpl;
import ua.com.alevel.entity.Session;

public class SessionDaoImpl implements SessionDao {
    @Override
    public void create(Session session) {
        SessionDBImpl.getInstance().create(session);
    }

    @Override
    public void update(Session session) {
        SessionDBImpl.getInstance().update(session);
    }

    @Override
    public void delete(Long id) {
        SessionDBImpl.getInstance().delete(id);
    }

    @Override
    public Session findById(Long id) {
        return SessionDBImpl.getInstance().findById(id);
    }

    @Override
    public Session[] findAll() {
        return SessionDBImpl.getInstance().findAll();
    }

    @Override
    public boolean exists(Long id) {
        return HallDBImpl.getInstance().exists(id);
    }


    @Override
    public boolean existsHallInSession(Long id) {
        return SessionDBImpl.getInstance().existsHallInSession(id);
    }

    @Override
    public boolean existsFilmInSession(Long id) {
        return SessionDBImpl.getInstance().existsFilmInSession(id);
    }

    @Override
    public int count() {
        return SessionDBImpl.getInstance().count();
    }
}
