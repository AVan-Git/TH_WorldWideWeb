package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.models.ProductImage;

import java.util.List;
import java.util.Optional;

public interface ProductImageService {
    void insert(ProductImage productImage);
    void update(ProductImage productImage);
    void delete(long id);
    Optional<ProductImage> getById(long id);
    List<ProductImage> getAll();

}
