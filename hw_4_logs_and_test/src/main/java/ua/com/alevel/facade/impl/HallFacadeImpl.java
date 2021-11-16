package ua.com.alevel.facade.impl;

import ua.com.alevel.dto.hall.HallCreateDto;
import ua.com.alevel.dto.hall.HallUpdateDto;
import ua.com.alevel.entity.Hall;
import ua.com.alevel.facade.HallFacade;
import ua.com.alevel.service.HallService;
import ua.com.alevel.service.SessionService;
import ua.com.alevel.service.impl.HallServiceImpl;
import ua.com.alevel.service.impl.SessionServiceImpl;
import ua.com.alevel.util.ConstGlobal;

import java.io.IOException;

public class HallFacadeImpl implements HallFacade {

    private final HallService hallService = new HallServiceImpl();
    private final SessionService sessionService = new SessionServiceImpl();

    @Override
    public void create(HallCreateDto hallCreateDto) {

        Hall hall = createHall(hallCreateDto);
        hallService.create(hall);
    }

    @Override
    public void update(HallUpdateDto hallUpdateDto) throws IOException {
        if (!exists(hallUpdateDto.getId())) {
            System.out.println(ConstGlobal.settings.getString("hall.id.not.found") + " " + hallUpdateDto.getId());
            ConstGlobal.loggerWarn.warn(ConstGlobal.settings.getString("hall.id.not.found") + " " + hallUpdateDto.getId());
            throw new IOException();
        } else {
            Hall hall = updateHall(hallUpdateDto);
            hallService.update(hall);
        }
    }

    @Override
    public void delete(Long id) throws IOException {
        if (existsHallInSession(id)) {
            System.out.println(ConstGlobal.settings.getString("hall.used.session"));
            ConstGlobal.loggerWarn.warn(ConstGlobal.settings.getString("hall.not.delete") + id);
            throw new IOException();
        } else if (!exists(id)) {
            System.out.println(ConstGlobal.settings.getString("hall.id.not.found") + " " + id);
            ConstGlobal.loggerWarn.warn(ConstGlobal.settings.getString("hall.id.not.found") + " " + id);
            throw new IOException();
        } else
            hallService.delete(id);
    }

    @Override
    public Hall findById(Long id) throws IOException {
        if (!exists(id)) {
            System.out.println(ConstGlobal.settings.getString("hall.id.not.found") + " " + id);
            ConstGlobal.loggerWarn.warn(ConstGlobal.settings.getString("hall.id.not.found") + " " + id);
            throw new IOException();
        } else {
            ConstGlobal.loggerInfo.info(ConstGlobal.settings.getString("hall.find.by.id") + id);
            return hallService.findById(id);
        }
    }

    @Override
    public Hall[] findAll() throws IOException {
        if (hallService.count() == 0) {
            System.out.println(ConstGlobal.settings.getString("hall.does.not.exist"));
            ConstGlobal.loggerWarn.warn(ConstGlobal.settings.getString("hall.does.not.exist"));
            throw new IOException();
        } else {
            return hallService.findAll();
        }
    }

    @Override
    public boolean exists(Long id) {
        return hallService.exists(id);
    }

    @Override
    public boolean existsHallInSession(Long id) {
        return sessionService.existsHallInSession(id);
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
