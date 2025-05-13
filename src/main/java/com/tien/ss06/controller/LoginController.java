package com.tien.ss06.controller;import java.io.*;

import com.tien.ss06.model.User;
import com.tien.ss06.service.UserService;
import com.tien.ss06.service.UserServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "LoginController", value = "/LoginController")
public class LoginController extends HttpServlet {
    private UserService userService;

    public LoginController() {
        userService = new UserServiceImp();
    }
    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("views/b2/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userService.login(username, password);
        if (user != null) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("views/b2/home.jsp");
        } else {
            req.setAttribute("error", "Ten dang nhap hoac mat khau sai");
            req.getRequestDispatcher("views/b2/login.jsp").forward(req, resp);
        }
    }
}
