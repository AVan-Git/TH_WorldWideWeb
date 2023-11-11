package vn.edu.iuh.fit.se.services;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.entity.ProductImage;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductImageService {
    boolean insert(ProductImage item);
    boolean update(ProductImage item);
    boolean delete(long id);
    Optional<ProductImage> getById(long id);
    List<ProductImage> getAll();

}
