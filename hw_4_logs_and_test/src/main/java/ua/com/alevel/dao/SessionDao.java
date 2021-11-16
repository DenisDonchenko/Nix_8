package ua.com.alevel.dao;

import ua.com.alevel.entity.Session;

public interface SessionDao extends BaseDao<Session> {

    boolean existsHallInSession(Long id);

    boolean existsFilmInSession(Long id);
}
