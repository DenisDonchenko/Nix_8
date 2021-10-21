package ua.com.alevel.service;

import ua.com.alevel.ProgramRun;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.entity.User;

public class UserService {
    private final UserDao userDao = new UserDao();

    public void create(User user) {
        if ( isUserExistByEmail(user.getEmail())  || isUserExistByPhoneNumber(user.getPhoneNumber())) {
            System.out.println("\nUser already exists\n");
            ProgramRun.run();
        } else {
            userDao.create(user);
        }
    }

    public void update(User user, Long id) {
        if (userDao.findById(id) == null) {
            System.out.println("\nUser with id = " + id + " already exists\n");
            ProgramRun.run();
        } else {
            user.setId(id);
            userDao.update(user);
        }

    }

    public void delete(Long id) {
        if (userDao.findById(id) == null) {
            System.out.println("\nUser with id = " + id + " already exists\n");
            ProgramRun.run();
        } else {
            userDao.delete(id);
        }
    }
    public User findById(Long id) {
        if (userDao.findById(id) == null) {
            System.out.println("\nUser with id = " + id + " already exists\n");
            ProgramRun.run();
        } else {
            return userDao.findById(id);
        }
        return null;
    }
    public User[] findAll() {
        return userDao.findAll();
    }

    private boolean isUserExistByEmail(String email) {
        return userDao.findByEmail(email) != null;
    }

    private boolean isUserExistByPhoneNumber(String phoneNumber) {
        return userDao.findByPhoneNumber(phoneNumber) != null;
    }
}
