package vn.edu.iuh.fit.service.impl;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.repositores.ProductRepository;
import vn.edu.iuh.fit.service.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    @Inject
    private ProductRepository repository;

    @Override
    public void insert(Product product) {
        repository.insert(product);
    }

    @Override
    public void update(Product product) {
        repository.insert(product);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public Optional<Product> getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Product> getAll() {
        return repository.getAll();
    }
}
