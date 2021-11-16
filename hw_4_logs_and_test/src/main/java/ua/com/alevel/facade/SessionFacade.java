package ua.com.alevel.facade;

import ua.com.alevel.dto.sessions.SessionCreateDto;
import ua.com.alevel.dto.sessions.SessionFindDto;
import ua.com.alevel.dto.sessions.SessionUpdateDto;

import java.io.IOException;

public interface SessionFacade {

    void create(SessionCreateDto entity);

    void update(SessionUpdateDto entity) throws IOException;

    void delete(Long id) throws IOException;

    SessionFindDto findById(Long id) throws IOException;

    SessionFindDto[] findAll() throws IOException;

    boolean exists(Long id);
}
