package vn.edu.iuh.fit.se.services;

import vn.edu.iuh.fit.se.entity.OrderDetail;
import vn.edu.iuh.fit.se.entity.ProductPrice;
import vn.edu.iuh.fit.se.entity.keyId.OrderDetailId;
import vn.edu.iuh.fit.se.entity.keyId.PriceId;

import java.util.List;
import java.util.Optional;

public interface ProductPriceService {
    boolean insert(ProductPrice item);
    boolean update(ProductPrice item);
    boolean delete(PriceId id);
    Optional<ProductPrice> getById(PriceId id);
    List<ProductPrice> getAll();

}
