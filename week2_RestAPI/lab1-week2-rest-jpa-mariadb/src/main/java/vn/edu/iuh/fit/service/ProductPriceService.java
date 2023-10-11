package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.models.ProductImage;
import vn.edu.iuh.fit.models.ProductPrice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductPriceService {
    void insert(ProductPrice price);
    void update(ProductPrice price);
    void delete(LocalDateTime id);
    Optional<ProductPrice> getById(LocalDateTime id);
    List<ProductPrice> getAll();

}
