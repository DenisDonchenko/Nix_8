package ua.com.alevel.service;

import ua.com.alevel.ProgramRun;
import ua.com.alevel.entity.User;

public interface UserService {

     void create(User user) ;
     void update(User user, Long id);
     void delete(Long id) ;
     User findById(Long id);
     User[] findAll();

}
