package vn.edu.iuh.fit.week1_demoservlet.repositories;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.week1_demoservlet.connection.ConnectionDB;
import vn.edu.iuh.fit.week1_demoservlet.models.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AccountRepositories {

    private Connection connect = null;

    public AccountRepositories() throws Exception {
        connect = new ConnectionDB().getConnectionBD();
    }

    // them 1 acc
    public void insert(Account account) throws Exception{
        String sql = "INSERT INTO Account VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, account.getAccount_id());
        ps.setString(2, account.getFull_name());
        ps.setString(3, account.getPassword());
        ps.setString(4, account.getEmail());
        ps.setString(5, account.getPhone());
        ps.setInt(6, account.getStatus());
        ps.executeUpdate();

    }

    // cap nhat acc
    public void update(Account account) throws Exception{
        String sql = "UPDATE Account set full_name=?, password=?, email=?, phone=?, status=? where account_id=?";
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(6, account.getAccount_id());
        ps.setString(1, account.getFull_name());
        ps.setString(2, account.getPassword());
        ps.setString(3, account.getEmail());
        ps.setString(4, account.getPhone());
        ps.setInt(5, account.getStatus());
        ps.executeUpdate();


    }




}
