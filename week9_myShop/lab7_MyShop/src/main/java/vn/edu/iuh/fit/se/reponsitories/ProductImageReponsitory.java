package vn.edu.iuh.fit.se.reponsitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.se.entity.ProductImage;

@Repository
public interface ProductImageReponsitory extends JpaRepository<ProductImage, Long> {
}
