package ua.com.alevel.db;

import ua.com.alevel.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    private final User[] users;
    private static UserDB instance;
    private static Long user_id = 1L;
    public static int realSizeArray = 0;
    private static int capasity = 10;
    private static int indexNewUser = 0;

    private UserDB() {
        users = new User[capasity];

    }

    public static UserDB getInstance() {
        if (instance == null) {
            instance = new UserDB();
        }
        return instance;
    }

    public void create(User user) {
        user.setId(user_id++);
        users[indexNewUser] = user;
        indexNewUser++;
        realSizeArray++;
        newCapacity();
    }

    public void update(User user) {
        User current = findById(user.getId());
        current.setName(user.getName());
        current.setBirthday(user.getBirthday());
        current.setEmail(user.getEmail());
        current.setPhoneNumber(user.getPhoneNumber());
    }

    public void delete(Long id) {
        int indexUser = findIndexById(id);
        removeItems(indexUser);
        realSizeArray--;
    }


    public User findById(Long id) {
        User isUser = null;
        try {
        for (User user : users) {
            if (user.getId() == id)
                isUser =  user;
        }
            return isUser;
        }
        catch (NullPointerException e){
            return isUser;
        }
    }

    public User findByEmail(String email) {
        User isUser = null;
        try {
            for (User user : users) {
                if (user.getEmail().contains(email))
                    isUser = user;
        }
        return isUser;
        }
        catch (NullPointerException e){
            return isUser;
        }
    }
    public User findByPhone(String phoneNumber) {
        User isUser = null;
        try {
            for (User user : users) {
                if (user.getEmail().contains(phoneNumber))
                    isUser = user;
            }
            return isUser;
        }
        catch (NullPointerException e){
            return isUser;
        }
    }
    private int findIndexById(Long id) {

        User user = findById(id);
        for (int i = 0; i < users.length; i++) {
            if (users[i] == user) {
                return i;
            }
        }
        return -1;
    }

    private void newCapacity() {
        capasity = capasity + (capasity / 2);
    }

    public User[] findAll() {
        return users;
    }

    private void removeItems(int... r) {
        int shift = 0;
        for (int i = 0; i < users.length; i++) {
            if (shift < r.length && i == r[shift])
                shift++;
            else
                users[i - shift] = users[i];
        }
        for (int i = users.length - shift; i < users.length; i++)
            users[i] = null;
    }

}
