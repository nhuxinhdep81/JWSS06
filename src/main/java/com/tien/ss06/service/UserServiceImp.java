package com.tien.ss06.service;


import com.tien.ss06.dao.UserDao;
import com.tien.ss06.dao.UserDaoImp;
import com.tien.ss06.model.User;

public class UserServiceImp implements UserService {
    private UserDao userDao;

    public UserServiceImp(){
        userDao = new UserDaoImp();
    }

    @Override
    public void registerUser(User user) {
        // Kiểm tra cơ bản
        if (user.getUsername() == null || user.getPassword() == null) {
            throw new IllegalArgumentException("Tên đăng nhập và mật khẩu là bắt buộc");
        }
        if (userDao.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("Tên đăng nhập đã tồn tại");
        }
        userDao.addUser(user);
    }

    @Override
    public User login(String username, String password) {
        User user = userDao.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
