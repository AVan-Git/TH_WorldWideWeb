package vn.edu.iuh.fit.week1_demoservlet.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week1_demoservlet.models.Account;
import vn.edu.iuh.fit.week1_demoservlet.sevice.impl.AccountSeviceImpl;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/saveAccount")
public class AccountSaveControl extends HttpServlet {

    private AccountSeviceImpl accountSevice = new AccountSeviceImpl();
    private PrintStream err;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        super.doPost(req, res);
        System.out.println("  1  ");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();


        String account_id = req.getParameter("id");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        int status = Integer.parseInt(req.getParameter("status"));

        Account acc = new Account(account_id, name, password, email, phone, status);
        System.out.println(acc.toString());
        try {
            accountSevice.insert(acc);
            out.print("<p>Record saved successfully!</p>");
            req.getRequestDispatcher("index.html").include(req,res);
            out.close();
        } catch (Exception e) {
            out.println("Sorry! unable to save record");
            err.println("controll - Save");
            System.err.println(e);
            out.close();
        }

        out.close();

    }
}
