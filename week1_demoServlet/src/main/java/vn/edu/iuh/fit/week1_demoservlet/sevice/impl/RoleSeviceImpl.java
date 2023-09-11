package vn.edu.iuh.fit.week1_demoservlet.sevice.impl;

import vn.edu.iuh.fit.week1_demoservlet.models.Role;
import vn.edu.iuh.fit.week1_demoservlet.repositories.RoleRepositories;
import vn.edu.iuh.fit.week1_demoservlet.sevice.RoleSevice;

import java.util.List;
import java.util.Optional;

public class RoleSeviceImpl implements RoleSevice {

    private RoleRepositories repositories = new RoleRepositories();

    @Override
    public void insert(Role role) throws Exception {
        repositories.insert(role);
    }

    @Override
    public void update(Role role) throws Exception {
        repositories.update(role);
    }

    @Override
    public void delete(String id) throws Exception {
        repositories.delete(id);
    }

    @Override
    public Optional<Role> getById(String id) throws Exception {
        return repositories.getById(id);
    }

    @Override
    public List<Role> getAll() throws Exception {
        return repositories.getAll();
    }
}
