package vn.edu.iuh.fit.se.services;

import vn.edu.iuh.fit.se.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    boolean insert(Customer customer);
    boolean update(Customer customer);
    boolean delete(long id);
    Optional<Customer> getById(long id);
    List<Customer> getAll();
}
