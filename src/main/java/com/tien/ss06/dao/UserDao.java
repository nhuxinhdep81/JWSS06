package com.tien.ss06.dao;

import com.tien.ss06.model.User;


public interface UserDao {
    void addUser(User user);
    User findByUsername(String username);
}
