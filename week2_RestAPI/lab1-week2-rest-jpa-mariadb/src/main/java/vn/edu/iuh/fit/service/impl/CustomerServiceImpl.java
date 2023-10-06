package vn.edu.iuh.fit.service.impl;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.models.Customer;
import vn.edu.iuh.fit.repositores.CustomerRepository;
import vn.edu.iuh.fit.service.CustomerService;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {
    @Inject
    private CustomerRepository repository;

    @Override
    public void insert(Customer customer) {
        repository.insert(customer);
    }

    @Override
    public void update(Customer customer) {
        repository.update(customer);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public Optional<Customer> getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Customer> getAll() {
        return repository.getAll();
    }
}
