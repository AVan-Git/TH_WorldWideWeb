package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.models.Order;
import vn.edu.iuh.fit.models.Product;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    void insert(Order order);
    void update(Order order);
    void delete(long id);
    Optional<Order> getById(long id);
    List<Order> getAll();

}
