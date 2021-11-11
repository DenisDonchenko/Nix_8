package ua.com.alevel.facade.impl;

import ua.com.alevel.dto.hall.HallCreateDto;
import ua.com.alevel.dto.hall.HallUpdateDto;
import ua.com.alevel.entity.Hall;
import ua.com.alevel.facade.HallFacade;
import ua.com.alevel.service.HallService;
import ua.com.alevel.service.impl.HallServiceImpl;

public class HallFacadeImpl implements HallFacade {

    private final HallService hallService = new HallServiceImpl();

    @Override
    public void create(HallCreateDto hallCreateDto) {
        Hall hall = createHall(hallCreateDto);
        hallService.create(hall);
    }

    @Override
    public void update(HallUpdateDto hallUpdateDto) {
        Hall hall = updateHall(hallUpdateDto);
        hallService.update(hall);
    }

    @Override
    public void delete(Long id) {
        hallService.delete(id);
    }

    @Override
    public Hall findById(Long id) {
        return hallService.findById(id);
    }

    @Override
    public Hall[] findAll() {
        return hallService.findAll();
    }

    private Hall createHall(HallCreateDto hallCreate) {
        String nameHall = hallCreate.getNameHall();
        int capacity = hallCreate.getCapacity();
        return new Hall(nameHall, capacity);
    }

    private Hall updateHall(HallUpdateDto hallUpdate) {
        Hall hallFromDB = hallService.findById(hallUpdate.getId());

        hallFromDB.setNameHall(hallUpdate.getNameHall());
        hallFromDB.setCapacity(hallUpdate.getCapacity());
        return hallFromDB;
    }
}
