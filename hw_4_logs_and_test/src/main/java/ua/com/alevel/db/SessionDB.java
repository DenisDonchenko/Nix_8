package ua.com.alevel.db;

import ua.com.alevel.entity.Session;

public interface SessionDB extends BaseDB<Session> {

    boolean existsHallInSession(Long id);

    boolean existsFilmInSession(Long id);
}
