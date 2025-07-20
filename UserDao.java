package com.thethinkers.smartfirst.dao;

import com.thethinkers.smartfirst.model.User;
import java.util.List;

public interface UserDao {
    void save(User user);
    User findByEmail(String email);
    List<User> findAll();
    boolean userExists(String email);
}