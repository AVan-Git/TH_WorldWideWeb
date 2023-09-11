package vn.edu.iuh.fit.week1_demoservlet.sevice;

import vn.edu.iuh.fit.week1_demoservlet.models.Role;

import java.util.List;
import java.util.Optional;

public interface RoleSevice {
    void insert(Role role) throws Exception;
    void update(Role role) throws Exception;
    void delete(String id) throws Exception;
    Optional<Role> getById(String id) throws Exception;
    List<Role> getAll() throws Exception;
}
