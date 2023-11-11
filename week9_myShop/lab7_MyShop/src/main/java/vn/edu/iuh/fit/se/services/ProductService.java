package vn.edu.iuh.fit.se.services;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.entity.Customer;
import vn.edu.iuh.fit.se.entity.Product;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    boolean insert(Product item);
    boolean update(Product item);
    boolean delete(long id);
    Optional<Product> getById(long id);
    List<Product> getAll();

}
