package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.models.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    void insert(Employee employee);
    void update(Employee employee);
    void delete(long id);
    Optional<Employee> getById(long id);
    List<Employee> getAll();

}
