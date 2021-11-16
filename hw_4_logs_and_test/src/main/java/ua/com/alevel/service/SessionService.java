package ua.com.alevel.service;

import ua.com.alevel.entity.Session;

public interface SessionService extends BaseService<Session> {
    boolean existsHallInSession(Long id);

    boolean existsFilmInSession(Long id);
}
