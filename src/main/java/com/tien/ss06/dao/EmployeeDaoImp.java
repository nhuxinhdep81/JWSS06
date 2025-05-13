package com.tien.ss06.dao;

import com.tien.ss06.model.Employee;
import com.tien.ss06.utils.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImp implements EmployeeDao {

    @Override
    public List<Employee> getAllEmployees(String keyword, String sortBy, int offset, int limit) {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees WHERE name LIKE ? OR id LIKE ? ORDER BY " + sortBy + " LIMIT ? OFFSET ?";
        try (Connection conn = ConnectionDB.openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            stmt.setInt(3, limit);
            stmt.setInt(4, offset);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Employee e = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("birthday").toLocalDate(),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getDouble("salary"),
                        rs.getString("position")
                );
                employees.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public int getTotalEmployees(String keyword) {
        String sql = "SELECT COUNT(*) FROM employees WHERE name LIKE ? OR id LIKE ?";
        try (Connection conn = ConnectionDB.openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        try (Connection conn = ConnectionDB.openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("birthday").toLocalDate(),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getDouble("salary"),
                        rs.getString("position")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addEmployee(Employee e) {
        String sql = "INSERT INTO employees (name, birthday, phone, email, salary, position) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionDB.openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getName());
            stmt.setDate(2, Date.valueOf(e.getBirthday()));
            stmt.setString(3, e.getPhone());
            stmt.setString(4, e.getEmail());
            stmt.setDouble(5, e.getSalary());
            stmt.setString(6, e.getPosition());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(Employee e) {
        String sql = "UPDATE employees SET name=?, birthday=?, phone=?, email=?, salary=?, position=? WHERE id=?";
        try (Connection conn = ConnectionDB.openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getName());
            stmt.setDate(2, Date.valueOf(e.getBirthday()));
            stmt.setString(3, e.getPhone());
            stmt.setString(4, e.getEmail());
            stmt.setDouble(5, e.getSalary());
            stmt.setString(6, e.getPosition());
            stmt.setInt(7, e.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (Connection conn = ConnectionDB.openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
