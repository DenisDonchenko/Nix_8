package ua.com.alevel.controller;

import ua.com.alevel.db.UserDB;
import ua.com.alevel.entity.User;
import ua.com.alevel.service.UserService;
import ua.com.alevel.service.impl.UserServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserController {
    private final UserService userServiceImpl = new UserServiceImpl();

    public void create(User newUser) {

        userServiceImpl.create(newUser);
    }

    public void update(User newUser, Long id) {
        userServiceImpl.update(newUser, id);
    }

    public void delete(Long id) {

        userServiceImpl.delete(id);
    }

    public void findById(Long id) {
        User user = userServiceImpl.findById(id);
        System.out.println("user = " + user);

    }

    public void findAll() {
        System.out.println("UserController.findAll");
        User[] users = userServiceImpl.findAll();
        if (users != null) {
            for (int i = 0; i < UserDB.realSizeArray; i++) {
                System.out.println("user = " + users[i].toString());
            }
        } else {
            System.out.println("users empty");
        }
    }
}
