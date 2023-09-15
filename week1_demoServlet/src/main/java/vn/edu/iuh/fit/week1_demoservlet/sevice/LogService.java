package vn.edu.iuh.fit.week1_demoservlet.sevice;

import vn.edu.iuh.fit.week1_demoservlet.models.Log;

import java.util.List;
import java.util.Optional;

public interface LogService {
    void insert(Log log) throws Exception;
    void update(Log log) throws Exception;
    void delete(int id) throws Exception;
    Optional<Log> getById(int id) throws Exception;
    List<Log> getAll() throws Exception;
}
