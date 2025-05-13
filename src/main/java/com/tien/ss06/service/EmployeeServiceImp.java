package com.tien.ss06.service;
import com.tien.ss06.dao.EmployeeDao;
import com.tien.ss06.dao.EmployeeDaoImp;
import com.tien.ss06.model.Employee;
import java.util.List;


import java.util.List;

public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeDao employeeDao = new EmployeeDaoImp();

    @Override
    public List<Employee> getEmployees(String keyword, String sortBy, int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        return employeeDao.getAllEmployees(keyword, sortBy, offset, pageSize);
    }

    @Override
    public int getTotalPages(String keyword, int pageSize) {
        int total = employeeDao.getTotalEmployees(keyword);
        return (int) Math.ceil((double) total / pageSize);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public void editEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    @Override
    public void removeEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }
}
