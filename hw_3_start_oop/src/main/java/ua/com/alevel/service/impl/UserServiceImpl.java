package ua.com.alevel.service.impl;

import ua.com.alevel.ProgramRun;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.entity.User;
import ua.com.alevel.service.UserService;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDao();

    @Override
    public void create(User user) {
        if (isUserExistByEmail(user.getEmail()) || isUserExistByPhoneNumber(user.getPhoneNumber())) {
            System.out.println("\nUser already exists\n");
            ProgramRun.run();
        } else {
            userDao.create(user);
        }
    }

    @Override
    public void update(User user, Long id) {
        if (userDao.findById(id) == null) {
            System.out.println("\nUser with id = " + id + " already exists\n");
            ProgramRun.run();
        } else {
            user.setId(id);
            userDao.update(user);
        }

    }

    @Override
    public void delete(Long id) {
        if (userDao.findById(id) == null) {
            System.out.println("\nUser with id = " + id + " already exists\n");
            ProgramRun.run();
        } else {
            userDao.delete(id);
        }
    }

    @Override
    public User findById(Long id) {
        if (userDao.findById(id) == null) {
            System.out.println("\nUser with id = " + id + " already exists\n");
            ProgramRun.run();
        } else {
            return userDao.findById(id);
        }
        return null;
    }

    @Override
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
