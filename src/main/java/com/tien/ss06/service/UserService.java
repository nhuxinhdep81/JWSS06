package com.tien.ss06.service;


import com.tien.ss06.model.User;

public interface UserService {
    void registerUser(User user);
    User login(String username, String password);
}
