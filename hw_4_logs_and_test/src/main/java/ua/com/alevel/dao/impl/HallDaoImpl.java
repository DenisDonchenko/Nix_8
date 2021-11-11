package ua.com.alevel.dao.impl;

import ua.com.alevel.dao.HallDao;
import ua.com.alevel.db.impl.HallDBImpl;
import ua.com.alevel.db.impl.SessionDBImpl;
import ua.com.alevel.entity.Hall;

public class HallDaoImpl implements HallDao {
    @Override
    public void create(Hall hall) { HallDBImpl.getInstance().create(hall); }

    @Override
    public void update(Hall hall) {
        HallDBImpl.getInstance().update(hall);
    }

    @Override
    public void delete(Long id) {
        HallDBImpl.getInstance().delete(id);
    }

    @Override
    public Hall findById(Long id) {
        return HallDBImpl.getInstance().findById(id);
    }

    @Override
    public Hall[] findAll() {
        return HallDBImpl.getInstance().findAll();
    }

    @Override
    public int count() {
        return HallDBImpl.getInstance().count();
    }
}
