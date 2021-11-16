package ua.com.alevel.service.impl;

import ua.com.alevel.dao.SessionDao;
import ua.com.alevel.dao.impl.SessionDaoImpl;
import ua.com.alevel.entity.Session;
import ua.com.alevel.service.SessionService;
import ua.com.alevel.util.ConstGlobal;

public class SessionServiceImpl implements SessionService {

    private final SessionDao sessionDao = new SessionDaoImpl();

    @Override
    public void create(Session session) {
        ConstGlobal.loggerInfo.info(ConstGlobal.settings.getString("session.create") + session.toString());
        sessionDao.create(session);
    }

    @Override
    public void update(Session session) {
        ConstGlobal.loggerInfo.info(ConstGlobal.settings.getString("session.update") + session.toString());
        sessionDao.update(session);
    }

    @Override
    public void delete(Long id) {
        ConstGlobal.loggerInfo.info(ConstGlobal.settings.getString("session.delete") + id);
        sessionDao.delete(id);
    }

    @Override
    public Session findById(Long id) {
        return sessionDao.findById(id);
    }

    @Override
    public Session[] findAll() {
        return sessionDao.findAll();
    }

    @Override
    public boolean exists(Long id) {
        return sessionDao.exists(id);
    }

    @Override
    public boolean existsHallInSession(Long id) {
        return sessionDao.existsHallInSession(id);
    }

    @Override
    public boolean existsFilmInSession(Long id) {
        return sessionDao.existsFilmInSession(id);
    }


    @Override
    public int count() {
        return sessionDao.count();
    }


}
