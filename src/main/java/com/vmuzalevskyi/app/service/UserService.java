package com.vmuzalevskyi.app.service;

import com.vmuzalevskyi.app.model.User;

import java.util.List;

/**
 * Created by root on 5/21/16.
 */
public interface UserService {

    User findById(long id);
    User findByName(String name);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserById(long id);
    List<User> findAllUsers();
    void deleteAllUsers();
    boolean isUserExist(User user);
}
