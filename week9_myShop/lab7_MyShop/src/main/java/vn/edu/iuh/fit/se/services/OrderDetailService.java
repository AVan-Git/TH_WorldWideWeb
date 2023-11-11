package vn.edu.iuh.fit.se.services;

import vn.edu.iuh.fit.se.entity.OrderDetail;
import vn.edu.iuh.fit.se.entity.keyId.OrderDetailId;

import java.util.List;
import java.util.Optional;

public interface OrderDetailService {
    boolean insert(OrderDetail item);
    boolean update(OrderDetail item);
    boolean delete(OrderDetailId id);
    Optional<OrderDetail> getById( OrderDetailId id);
    List<OrderDetail> getAll();

}
