package vn.edu.iuh.fit.se.reponsitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.se.entity.OrderDetail;
import vn.edu.iuh.fit.se.entity.keyId.OrderDetailId;

@Repository
public interface OrderDetailReponsitory extends JpaRepository<OrderDetail, OrderDetailId> {
}
