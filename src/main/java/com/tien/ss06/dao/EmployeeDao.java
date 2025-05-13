package com.tien.ss06.dao;


import com.tien.ss06.model.Employee;

import java.util.List;


public interface EmployeeDao {
    List<Employee> getAllEmployees(String keyword, String sortBy, int offset, int limit);
    int getTotalEmployees(String keyword);
    Employee getEmployeeById(int id);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
}

