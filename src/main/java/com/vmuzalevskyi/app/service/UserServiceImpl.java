package com.vmuzalevskyi.app.service;

import com.vmuzalevskyi.app.model.User;
import com.vmuzalevskyi.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by root on 5/21/16.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements  UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAllUsers() {
        return repository.findAll();
    }

    public User findById(long id) {
        return repository.findOne(id);
    }

    public User findByName(String name) {
        return repository.findUserByUsername(name);
    }

    public void saveUser(User user) {
        repository.save(user);
    }

    public void updateUser(User user) {
        repository.save(user);
    }

    public void deleteUserById(long id) {
        repository.delete(id);
    }

    public boolean isUserExist(User user) {
        return repository.exists(user.getId());
    }

    public void deleteAllUsers(){
        repository.deleteAll();
    }
}
