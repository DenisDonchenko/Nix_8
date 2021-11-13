package ua.com.alevel.facade;

import ua.com.alevel.dto.sessions.SessionCreateDto;
import ua.com.alevel.dto.sessions.SessionFindDto;
import ua.com.alevel.dto.sessions.SessionUpdateDto;

public interface SessionFacade {

    void create(SessionCreateDto entity);

    void update(SessionUpdateDto entity);

    void delete(Long id);

    SessionFindDto findById(Long id);

    SessionFindDto[] findAll();
}
