package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.models.Customer;
import vn.edu.iuh.fit.models.Employee;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    void insert(Customer customer);
    void update(Customer customer);
    void delete(long id);
    Optional<Customer> getById(long id);
    List<Customer> getAll();

}
