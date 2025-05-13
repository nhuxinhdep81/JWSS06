package com.tien.ss06.controller;

import java.io.*;

import com.tien.ss06.model.User;
import com.tien.ss06.service.UserService;
import com.tien.ss06.service.UserServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "RegisterController", value = "/RegisterController")
public class RegisterController extends HttpServlet {
    private UserService userService;

    public RegisterController() {
        userService = new UserServiceImp();
    }

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("views/b2/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            User user = new User();
            user.setUsername(req.getParameter("username"));
            user.setPassword(req.getParameter("password"));
            user.setEmail(req.getParameter("email"));
            user.setPhone(req.getParameter("phone"));

            userService.registerUser(user);
            resp.sendRedirect("LoginController");
        } catch (IllegalArgumentException e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("views/b2/register.jsp").forward(req, resp);
        }
    }
}
