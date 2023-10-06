package vn.edu.iuh.fit.service.impl;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.models.OrderDetail;
import vn.edu.iuh.fit.repositores.OrderDetailRepository;
import vn.edu.iuh.fit.repositores.OrderRepository;
import vn.edu.iuh.fit.service.OrderDetailService;

import java.util.List;
import java.util.Optional;

public class OrderDetailServiceImpl implements OrderDetailService {
    @Inject
    private OrderDetailRepository repository;
    @Override
    public void insert(OrderDetail orderDetail) {
        repository.insert(orderDetail);
    }

    @Override
    public void update(OrderDetail orderDetail) {
        repository.update(orderDetail);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public Optional<OrderDetail> getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<OrderDetail> getAll() {
        return repository.getAll();
    }
}
