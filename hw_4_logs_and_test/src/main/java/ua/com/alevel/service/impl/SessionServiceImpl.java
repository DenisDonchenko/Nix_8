package ua.com.alevel.service.impl;

import ua.com.alevel.dao.SessionDao;
import ua.com.alevel.dao.impl.SessionDaoImpl;
import ua.com.alevel.entity.Session;
import ua.com.alevel.service.SessionService;

public class SessionServiceImpl implements SessionService {

    private final SessionDao sessionDao = new SessionDaoImpl();

    @Override
    public void create(Session session) {
        sessionDao.create(session);
    }

    @Override
    public void update(Session session) {
        sessionDao.update(session);
    }

    @Override
    public void delete(Long id) {
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


}
