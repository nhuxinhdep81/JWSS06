package com.tien.ss06.dao;


import com.tien.ss06.model.User;
import com.tien.ss06.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImp implements UserDao {

    @Override
    public void addUser(User user) {
        try (Connection conn = ConnectionDB.openConnection();
             CallableStatement cs = conn.prepareCall("{CALL AddUser(?, ?, ?, ?)}")) {
            cs.setString(1, user.getUsername());
            cs.setString(2, user.getPassword());
            cs.setString(3, user.getEmail());
            cs.setString(4, user.getPhone());
            cs.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi khi thêm người dùng", e);
        }
    }


    @Override
    public User findByUsername(String username) {
        try (Connection conn = ConnectionDB.openConnection();
             CallableStatement cs = conn.prepareCall("{CALL FindUserByUsername(?)}")) {
            cs.setString(1, username);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("phone")
                );
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi khi tìm người dùng", e);
        }
    }
}