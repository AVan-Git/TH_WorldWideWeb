package vn.edu.iuh.fit.week1_demoservlet.repositories;

import vn.edu.iuh.fit.week1_demoservlet.connection.ConnectionDB;
import vn.edu.iuh.fit.week1_demoservlet.models.Log;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LogRepositories {

    private Connection connection = null;

    public LogRepositories() {
        try {
            connection = new ConnectionDB().getConnectionBD();
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("LogRepositories() ");
        }
    }
//    public Log(
//      int id,
//      String account_id,
//      Date ngayLogin,
//      Date ngayLogout,
//      String note
//      )

    // insert
    public void insert(Log log) throws Exception {
        String sql = "INSERT INTO Log VALUES (?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, log.getId());
        ps.setString(2, log.getAccount_id());
        ps.setDate(3, log.getNgayLogin());
        ps.setDate(4, log.getNgayLogout());
        ps.setString(5, log.getNote());
        ps.executeUpdate();
    }

    // update
    public void update(Log log) throws Exception {
        String sql = "UPDATE log set account_id=?, ngayLogin=?, ngayLogout=?, note=? WHERE id =?  ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(5, log.getId());
        ps.setString(1, log.getAccount_id());
        ps.setDate(2, log.getNgayLogin());
        ps.setDate(3, log.getNgayLogout());
        ps.setString(4, log.getNote());
        ps.executeUpdate();
    }

    // del
    public void delete(int maXoa) throws Exception {
        String sql = "DELETE FROM Log WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, maXoa);
        ps.executeUpdate();
    }

    // getById
    public Optional<Log> getById(int maTim) throws Exception {
        String sql = "SELECT * FROM Log WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, maTim);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Log a = new Log(rs.getInt(1), rs.getString(2)
                    , rs.getDate(3)
                    , rs.getDate(4)
                    , rs.getString(5));
            return Optional.of(a);
        }
        return Optional.empty();
    }

    // getAll
    public List<Log> getAll() throws Exception {
        List<Log> lst = new ArrayList<>();
        String sql = "SELECT * FROM Log";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            Log a = new Log(rs.getInt(1), rs.getString(2)
                    , rs.getDate(3)
                    , rs.getDate(4)
                    , rs.getString(5));
            lst.add(a);
        }

        return lst;
    }
}
