package ua.com.alevel.db.impl;

import ua.com.alevel.db.HallDB;
import ua.com.alevel.entity.Hall;
import ua.com.alevel.util.DBHelper;

import java.util.Objects;

public class HallDBImpl implements HallDB {

    private static HallDBImpl instance;

    private Hall[] halls;

    private static Long hall_id = 1L;
    public static int realSizeArray = 0;
    private static int capacity = 10;
    private static int indexNewHall = 0;

    private HallDBImpl() {
        halls = new Hall[capacity];
    }

    public static HallDBImpl getInstance() {
        if (instance == null) {
            instance = new HallDBImpl();
        }
        return instance;
    }

    @Override
    public void create(Hall hall) {
        if (realSizeArray == capacity - 1) {
            halls = DBHelper.newCapacity(capacity, halls);
            capacity = halls.length;
        }
        hall.setId(hall_id++);
        halls[indexNewHall] = hall;
        indexNewHall++;
        realSizeArray++;
    }

    @Override
    public void update(Hall hall) {
        halls[findIndexById(hall.getId())] = hall;
    }

    @Override
    public void delete(Long id) {
        int indexHall = findIndexById(id);
        halls = DBHelper.removeItems(halls, indexHall);
        realSizeArray--;
    }

    @Override
    public Hall findById(Long id) {
        for (Hall hall : halls) {
            if (Objects.equals(hall.getId(), id)) {
                return hall;
            }
        }
        throw new RuntimeException("Hall with id - " + id + " not found");
    }

    @Override
    public Hall[] findAll() {
        Hall[] allHalls = new Hall[realSizeArray];
        for (int i = 0; i < realSizeArray; i++) {
            if (halls[i] != null) {
                allHalls[i] = halls[i];
            }

        }
        return allHalls;
    }

    @Override
    public int count() {
        return realSizeArray;
    }

    private int findIndexById(Long id) {

        for (int i = 0; i < halls.length; i++) {
            if (Objects.equals(halls[i].getId(), id)) {
                return i;
            }
        }
        throw new RuntimeException("Hall with id - " + id + " not found");
    }
}
