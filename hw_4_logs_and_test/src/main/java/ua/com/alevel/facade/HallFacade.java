package ua.com.alevel.facade;

import ua.com.alevel.dto.hall.HallCreateDto;
import ua.com.alevel.dto.hall.HallUpdateDto;
import ua.com.alevel.entity.Hall;

import java.io.IOException;

public interface HallFacade {
    void create(HallCreateDto hallCreateDto);

    void update(HallUpdateDto hallUpdateDto) throws IOException;

    void delete(Long id) throws IOException;

    Hall findById(Long id) throws IOException;

    Hall[] findAll() throws IOException;

    boolean exists(Long id);

    boolean existsHallInSession(Long id);
}
