package com.tien.ss06.service;

import com.tien.ss06.model.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees(String keyword, String sortBy, int page, int pageSize);
    int getTotalPages(String keyword, int pageSize);
    Employee getEmployeeById(int id);
    void createEmployee(Employee employee);
    void editEmployee(Employee employee);
    void removeEmployee(int id);
}

