package ua.com.alevel.service.impl;

import ua.com.alevel.dao.HallDao;
import ua.com.alevel.dao.impl.HallDaoImpl;
import ua.com.alevel.entity.Hall;
import ua.com.alevel.service.HallService;
import ua.com.alevel.util.ConstGlobal;

public class HallServiceImpl implements HallService {

    private final HallDao hallDao = new HallDaoImpl();

    @Override
    public void create(Hall entity) {
        ConstGlobal.loggerInfo.info(ConstGlobal.settings.getString("hall.create") + entity.toString());
        hallDao.create(entity);
    }

    @Override
    public void update(Hall entity) {
        ConstGlobal.loggerInfo.info(ConstGlobal.settings.getString("hall.update") + entity.toString());
        hallDao.update(entity);
    }

    @Override
    public void delete(Long id) {
        ConstGlobal.loggerInfo.info(ConstGlobal.settings.getString("hall.delete") + id);
        hallDao.delete(id);
    }

    @Override
    public Hall findById(Long id) {
        return hallDao.findById(id);
    }

    @Override
    public Hall[] findAll() {
        return hallDao.findAll();
    }

    @Override
    public boolean exists(Long id) {
        return hallDao.exists(id);
    }


    @Override
    public int count() {
        return hallDao.count();
    }
}
