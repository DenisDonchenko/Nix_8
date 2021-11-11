package ua.com.alevel.service.impl;

import ua.com.alevel.dao.HallDao;
import ua.com.alevel.dao.impl.HallDaoImpl;
import ua.com.alevel.entity.Hall;
import ua.com.alevel.service.HallService;

public class HallServiceImpl implements HallService {

    private final HallDao hallDao = new HallDaoImpl();

    @Override
    public void create(Hall entity) {
        hallDao.create(entity);
    }

    @Override
    public void update(Hall entity) {
        hallDao.update(entity);
    }

    @Override
    public void delete(Long id) {
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
}
