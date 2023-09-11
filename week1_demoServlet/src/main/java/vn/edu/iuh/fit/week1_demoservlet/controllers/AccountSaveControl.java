package vn.edu.iuh.fit.week1_demoservlet.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week1_demoservlet.sevice.impl.AccountSeviceImpl;

import java.io.IOException;

@WebServlet(urlPatterns = "/saveAccount")
public class AccountSaveControl extends HttpServlet {

    private AccountSeviceImpl accountSevice;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);


    }
}
