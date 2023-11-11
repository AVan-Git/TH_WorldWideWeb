package vn.edu.iuh.fit.se.services;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.entity.Employee;

import java.util.List;
import java.util.Optional;


@Service
public interface EmployeeService {
    boolean insert(Employee emplyee);
    boolean update(Employee emplyee);
    boolean delete(long id);
    Optional<Employee> getById(long id);
    List<Employee> getAll();

}
