package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.models.Order;
import vn.edu.iuh.fit.models.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface OrderDetailService {
    void insert(OrderDetail orderDetail);
    void update(OrderDetail orderDetail);
    void delete(long id);
    Optional<OrderDetail> getById(long id);
    List<OrderDetail> getAll();

}
