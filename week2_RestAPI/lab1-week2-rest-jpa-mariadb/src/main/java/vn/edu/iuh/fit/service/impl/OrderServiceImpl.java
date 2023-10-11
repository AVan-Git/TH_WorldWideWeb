package vn.edu.iuh.fit.service.impl;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.models.Order;
import vn.edu.iuh.fit.repositores.OrderRepository;
import vn.edu.iuh.fit.service.OrderService;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {
    @Inject
    private OrderRepository repository;

    @Override
    public void insert(Order order) {
        repository.insert(order);
    }

    @Override
    public void update(Order order) {
        repository.update(order);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public Optional<Order> getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Order> getAll() {
        return repository.getAll();
    }
}
