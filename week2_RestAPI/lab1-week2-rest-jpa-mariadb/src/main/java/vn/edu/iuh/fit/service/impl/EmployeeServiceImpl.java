package vn.edu.iuh.fit.service.impl;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.repositores.EmployeeRepository;
import vn.edu.iuh.fit.service.EmployeeService;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {
    @Inject
    private EmployeeRepository repository;

    @Override
    public void insert(Employee employee) {
        repository.insert(employee);
    }

    @Override
    public void update(Employee employee) {
repository.update(employee);
    }

    @Override
    public void delete(long id) {
repository.delete(id);
    }

    @Override
    public Optional<Employee> getById(long id) {
        return repository.findbyId(id);
    }

    @Override
    public List<Employee> getAll() {
        return repository.getAllEmployee();
    }
}
