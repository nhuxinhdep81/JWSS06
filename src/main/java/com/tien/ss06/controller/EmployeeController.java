package com.tien.ss06.controller;

import java.io.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.tien.ss06.model.Employee;
import com.tien.ss06.service.EmployeeService;
import com.tien.ss06.service.EmployeeServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/employees")
public class EmployeeController extends HttpServlet {
    private final EmployeeService employeeService = new EmployeeServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";

        switch (action) {
            case "add":
                req.getRequestDispatcher("views/b3/addEmployee.jsp").forward(req, resp);
                break;
            case "edit":
                int idEdit = Integer.parseInt(req.getParameter("id"));
                Employee employeeEdit = employeeService.getEmployeeById(idEdit);
                req.setAttribute("employee", employeeEdit);
                req.getRequestDispatcher("views/b3/updateEmployee.jsp").forward(req, resp);
                break;
            case "delete":
                int idDelete = Integer.parseInt(req.getParameter("id"));
                employeeService.removeEmployee(idDelete);
                resp.sendRedirect("employees");
                break;
            default:
                String keyword = req.getParameter("keyword") != null ? req.getParameter("keyword") : "";
                String sortBy = req.getParameter("sortBy") != null ? req.getParameter("sortBy") : "id";
                int page = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 1;
                int pageSize = 5;

                List<Employee> employees = employeeService.getEmployees(keyword, sortBy, page, pageSize);
                int totalPages = employeeService.getTotalPages(keyword, pageSize);

                req.setAttribute("employees", employees);
                req.setAttribute("keyword", keyword);
                req.setAttribute("sortBy", sortBy);
                req.setAttribute("currentPage", page);
                req.setAttribute("totalPages", totalPages);

                req.getRequestDispatcher("views/b3/employeeList.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String action = req.getParameter("action");
        if (action == null) action = "";

        String name = req.getParameter("name");
        LocalDate birthday = LocalDate.parse(req.getParameter("birthday"));
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        double salary = Double.parseDouble(req.getParameter("salary"));
        String position = req.getParameter("position");

        switch (action) {
            case "add":
                Employee newEmp = new Employee(0, name, birthday, phone, email, salary, position);
                employeeService.createEmployee(newEmp);
                break;
            case "edit":
                int id = Integer.parseInt(req.getParameter("id"));
                Employee updateEmp = new Employee(id, name, birthday, phone, email, salary, position);
                employeeService.editEmployee(updateEmp);
                break;
        }

        resp.sendRedirect("employees");
    }
}
