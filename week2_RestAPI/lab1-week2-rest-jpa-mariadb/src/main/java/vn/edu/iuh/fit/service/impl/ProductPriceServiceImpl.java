package vn.edu.iuh.fit.service.impl;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.models.ProductPrice;
import vn.edu.iuh.fit.repositores.ProductPriceRepository;
import vn.edu.iuh.fit.service.ProductPriceService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ProductPriceServiceImpl implements ProductPriceService {
    @Inject
    private ProductPriceRepository repository;

    @Override
    public void insert(ProductPrice price) {
        repository.insert(price);
    }

    @Override
    public void update(ProductPrice price) {
        repository.update(price);
    }

    @Override
    public void delete(LocalDateTime id) {
        repository.delete(id);
    }

    @Override
    public Optional<ProductPrice> getById(LocalDateTime id) {
        return repository.getById(id);
    }

    @Override
    public List<ProductPrice> getAll() {
        return repository.getAll();
    }
}
