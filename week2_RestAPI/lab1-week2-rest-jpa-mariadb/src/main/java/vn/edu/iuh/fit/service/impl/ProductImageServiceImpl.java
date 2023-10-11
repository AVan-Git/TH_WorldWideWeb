package vn.edu.iuh.fit.service.impl;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.models.ProductImage;
import vn.edu.iuh.fit.repositores.ProductImageRepository;
import vn.edu.iuh.fit.service.ProductImageService;

import java.util.List;
import java.util.Optional;

public class ProductImageServiceImpl implements ProductImageService {
    @Inject
    private ProductImageRepository repository;

    @Override
    public void insert(ProductImage productImage) {
        repository.insert(productImage);
    }

    @Override
    public void update(ProductImage productImage) {
        repository.update(productImage);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public Optional<ProductImage> getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<ProductImage> getAll() {
        return repository.getAll();
    }
}
