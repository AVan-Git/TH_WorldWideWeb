package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.models.Customer;
import vn.edu.iuh.fit.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    void insert(Product product);
    void update(Product product);
    void delete(long id);
    Optional<Product> getById(long id);
    List<Product> getAll();

}
