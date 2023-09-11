package vn.edu.iuh.fit.week1_demoservlet.repositories;

import vn.edu.iuh.fit.week1_demoservlet.connection.ConnectionDB;
import vn.edu.iuh.fit.week1_demoservlet.models.GrantAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class GrantAccessRepositories {
    private Connection connect = null;
    public GrantAccessRepositories() {
        try {
            connect =  new ConnectionDB().getConnectionBD();
        }
        catch (Exception e)
        {
            System.err.println("GrantAccessRepositories");
            System.err.println(e);
        }
    }
    //GrantAccess(
    //      String account_id
    //      , String role_id
    //      , String is_grant
    //      , String note )

    //insert
    public void insert(GrantAccess val) throws Exception{
        String sql = "INSERT INTO GrantAcces VALUES (?,?,?,?)";
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, val.getAccount_id());
        ps.setString(2, val.getRole_id());
        ps.setString(3, val.getIs_grant());
        ps.setString(4, val.getNote());
        ps.executeUpdate();
    }

    //update
    public void update(GrantAccess val) throws Exception{
        System.err.println("err update GrantAccess -- chua biet where lay cai nao");
//        String sql = "UPDATE GrantAccess set account_id=?, role_id=?, is_grant=?, note=? WHERE account_id=? ";
//        PreparedStatement ps = connect.prepareStatement(sql);
    }
    //del

    //getbyid
    //getall
}
