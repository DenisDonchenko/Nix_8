package ua.com.alevel.db.impl;

import ua.com.alevel.db.SessionDB;
import ua.com.alevel.entity.Session;
import ua.com.alevel.util.DBHelper;

import java.util.Objects;

public class SessionDBImpl implements SessionDB {

    private static SessionDBImpl instance;
    private Session[] sessions;

    private static Long session_id = 1L;
    public static int realSizeArray = 0;
    private static int capacity = 10;
    private static int indexNewSession = 0;

    public SessionDBImpl() {
        sessions = new Session[capacity];
    }

    public static SessionDBImpl getInstance() {
        if (instance == null) {
            instance = new SessionDBImpl();
        }
        return instance;
    }

    @Override
    public void create(Session session) {
        if (realSizeArray == capacity - 1) {
            sessions = DBHelper.newCapacity(capacity, sessions);
            capacity = sessions.length;
        }
        session.setId(session_id++);
        sessions[indexNewSession] = session;
        indexNewSession++;
        realSizeArray++;
    }

    @Override
    public void update(Session session) {
        sessions[findIndexById(session.getId())] = session;

    }

    @Override
    public void delete(Long id) {
        int indexHall = findIndexById(id);
        sessions = DBHelper.removeItems(sessions, indexHall);
        realSizeArray--;
    }

    @Override
    public Session findById(Long id) {
        for (Session session : sessions) {
            if (Objects.equals(session.getId(), id)) {
                return session;
            }
        }
        throw new RuntimeException("Session with id - " + id + " not found");
    }

    @Override
    public Session[] findAll() {
        Session[] allSessions = new Session[realSizeArray];
        for (int i = 0; i < realSizeArray; i++) {
            if (sessions[i] != null) {
                allSessions[i] = sessions[i];
            }
        }
        return allSessions;
    }

    @Override
    public int count() {
        return realSizeArray;
    }

    private int findIndexById(Long id) {

        for (int i = 0; i < sessions.length; i++) {
            if (Objects.equals(sessions[i].getId(), id)) {
                return i;
            }
        }
        throw new RuntimeException("Session with id - " + id + " not found");
    }
}
