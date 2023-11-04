package vn.edu.iuh.fit.se.reponsitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.se.entity.Customer;
import vn.edu.iuh.fit.se.entity.Product;

@Repository
public interface ProductReponsitory extends JpaRepository<Product, Long> {
}
