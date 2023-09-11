package vn.edu.iuh.fit.week1_demoservlet.repositories;

import vn.edu.iuh.fit.week1_demoservlet.connection.ConnectionDB;
import vn.edu.iuh.fit.week1_demoservlet.models.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoleRepositories  {

    private Connection connect = null;

    public RoleRepositories() {

        try {
            connect = new ConnectionDB().getConnectionBD();
        }catch (Exception e) {
            System.err.println("RoleRepositories");
            System.err.println(e);
        }
    }

    // public Role(
    //      String role_id,
    //      String role_name,
    //      String description,
    //      int status  )
    public void insert(Role role) throws Exception{
        String sql = "INSERT INTO Role VALUES (?,?,?,?)";
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, role.getRole_id());
        ps.setString(2, role.getRole_name());
        ps.setString(3, role.getDescription());
        ps.setInt(4, role.getStatus());
        ps.executeUpdate();
    }

    //
    public void update(Role role) throws Exception{
        String sql = "UPDATE Role set role_name=?, description=?, status=? WHERE role_id=?  ";
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, role.getRole_name());
        ps.setString(2, role.getDescription());
        ps.setInt(3, role.getStatus());
        ps.setString(4, role.getRole_id());
        ps.executeUpdate();
    }
    // del
    public void delete(String maXoa) throws Exception{
        String sql = "DELETE FROM Role WHERE role_id=? ";
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, maXoa);
        ps.executeUpdate();
    }

    // get 1
    public Optional<Role> getById(String maTim) throws Exception{
        String sql = "SELECT * FROM Role WHERE role_id=? ";
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, maTim);
        ResultSet rs = ps.executeQuery();
        if (rs.next())
        {
            Role e = new Role(rs.getString(1)
                        ,rs.getString(2)
                        , rs.getString(3)
                        , rs.getInt(4)
                        );
            return Optional.of(e);
        }

        return Optional.empty();
    }

    //getAll
    public List<Role> getAll() throws Exception{
        List<Role> lst = new ArrayList<>();
        String sql = "SELECT * FROM Role";
        PreparedStatement ps = connect.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            lst.add(new Role(rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4)
                    ));
        }

        return lst;
    }
}
