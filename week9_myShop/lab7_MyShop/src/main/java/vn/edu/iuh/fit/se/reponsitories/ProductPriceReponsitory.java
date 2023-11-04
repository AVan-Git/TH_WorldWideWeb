package vn.edu.iuh.fit.se.reponsitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.se.entity.ProductPrice;
import vn.edu.iuh.fit.se.entity.keyId.PriceId;

@Repository
public interface ProductPriceReponsitory extends JpaRepository<ProductPrice, PriceId> {
}
