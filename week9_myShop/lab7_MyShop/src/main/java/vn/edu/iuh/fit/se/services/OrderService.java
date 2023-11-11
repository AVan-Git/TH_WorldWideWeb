package vn.edu.iuh.fit.se.services;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.entity.Order;

import java.util.List;
import java.util.Optional;


@Service
public interface OrderService {
    boolean insert(Order order);
    boolean update(Order order);
    boolean delete(long id);
    Optional<Order> getById(long id);
    List<Order> getAll();

}
