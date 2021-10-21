package ua.com.alevel.dao;

import ua.com.alevel.db.UserDB;
import ua.com.alevel.entity.User;

import java.time.LocalDate;

public class UserDao {

    public void create(User user) {
        UserDB.getInstance().create(user);
    }

    public void update(User user) {
        UserDB.getInstance().update(user);
    }

    public void delete(Long id) {
        UserDB.getInstance().delete(id);
    }

    public User findById(Long id) {
        return UserDB.getInstance().findById(id);
    }

    public User[] findAll() {
        return UserDB.getInstance().findAll();
    }

    public User findByEmail(String email){ return  UserDB.getInstance().findByEmail(email); }

    public User findByPhoneNumber(String phoneNumber){ return  UserDB.getInstance().findByPhone(phoneNumber);}


}
