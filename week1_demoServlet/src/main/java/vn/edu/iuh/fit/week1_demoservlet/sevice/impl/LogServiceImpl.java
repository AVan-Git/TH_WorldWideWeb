package vn.edu.iuh.fit.week1_demoservlet.sevice.impl;

import vn.edu.iuh.fit.week1_demoservlet.models.Log;
import vn.edu.iuh.fit.week1_demoservlet.repositories.LogRepositories;
import vn.edu.iuh.fit.week1_demoservlet.sevice.LogService;

import java.util.List;
import java.util.Optional;

public class LogServiceImpl implements LogService {

    private LogRepositories repositories = new LogRepositories();
    @Override
    public void insert(Log log) throws Exception {
        repositories.insert(log);
    }

    @Override
    public void update(Log log) throws Exception {
        repositories.update(log);
    }

    @Override
    public void delete(int id) throws Exception {
        repositories.delete(id);
    }

    @Override
    public Optional<Log> getById(int id) throws Exception {
        return repositories.getById(id);
    }

    @Override
    public List<Log> getAll() throws Exception {
        return repositories.getAll();
    }
}
