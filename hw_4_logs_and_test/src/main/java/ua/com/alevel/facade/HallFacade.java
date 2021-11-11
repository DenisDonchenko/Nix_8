package ua.com.alevel.facade;

import ua.com.alevel.dto.hall.HallCreateDto;
import ua.com.alevel.dto.hall.HallUpdateDto;
import ua.com.alevel.entity.Hall;

public interface HallFacade {
    void create(HallCreateDto hallCreateDto);

    void update(HallUpdateDto hallUpdateDto);

    void delete(Long id);

    Hall findById(Long id);

    Hall[] findAll();
}
