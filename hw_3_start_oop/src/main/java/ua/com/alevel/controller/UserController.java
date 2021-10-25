package ua.com.alevel.controller;

import ua.com.alevel.db.UserDB;
import ua.com.alevel.entity.User;
import ua.com.alevel.service.UserService;
import ua.com.alevel.service.impl.UserServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserController {
    private final UserService userServiceImpl = new UserServiceImpl();

    private void createUsers() {
        System.out.println("UserController.create");
        User[] users = new User[4];

        User user1 = new User();
        user1.setName("Pety");
        user1.setPhoneNumber("0969201844");
        user1.setEmail("pety@gmail.com");
        users[0] = user1;

        User user2 = new User();
        user2.setName("Ivan");
        user2.setPhoneNumber("0982719438");
        user2.setEmail("ivan@gmail.com");
        users[1] = user2;

        User user3 = new User();
        user3.setName("Maks");
        user3.setPhoneNumber("0961920344");
        user3.setEmail("maks@gmail.com");
        users[2] = user3;

        User user4 = new User();
        user4.setName("Katy");
        user4.setPhoneNumber("0982719438");
        user4.setEmail("kary@gmail.com");
        users[3] = user4;

        for (int i = 0; i < users.length; i++) {
            userServiceImpl.create(users[i]);
        }


    }

    public void create(User newUser) {

        userServiceImpl.create(newUser);
    }
    public void update(User newUser,Long id) {
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

    private LocalDate addDate(String date) {
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(date, formatter1);
    }


}
