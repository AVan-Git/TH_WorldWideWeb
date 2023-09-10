package vn.edu.iuh.fit.week1_demoservlet.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week1_demoservlet.models.Account;
import vn.edu.iuh.fit.week1_demoservlet.sevice.AccountSevice;
import vn.edu.iuh.fit.week1_demoservlet.sevice.impl.AccountSeviceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/accounts")
public class AccountControl extends HttpServlet {

    private AccountSeviceImpl accountSevice = new AccountSeviceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        super.doGet(req, res);
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<a href='index.html'> Add New Account </a>");
        out.println("<h1>Account List</h1>");

        try {
            List<Account> lst = accountSevice.getAll();

            out.print("<table border='1' width='100%'>");
            out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Phone</th> " +
                    "<th>Status</th><th>Edit</th><th>Delete</th></tr>");
            for (Account e : lst) {
                out.print("<tr><td>" + e.getAccount_id() +
                        "</td><td>" + e.getFull_name() +
                        "</td><td>" + e.getPassword() +
                        "</td><td>" + e.getEmail() +
                        "</td><td>" + e.getPhone() +
                        "</td><td>" + e.getStatus() +
                        "</td><td><a href='EditServlet?id=" + e.getAccount_id() + "'>edit</a></td>" +
                        "<td><a href='DeleteServlet?id=" + e.getAccount_id() + "'>delete</a></td>" +
                        "</tr>");
            }

            out.print("</table>");
            out.close();

        } catch (Exception e) {
            System.err.println(e);
        }


    }
}
