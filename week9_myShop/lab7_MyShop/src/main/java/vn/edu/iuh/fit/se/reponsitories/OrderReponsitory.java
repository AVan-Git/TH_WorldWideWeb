package vn.edu.iuh.fit.se.reponsitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.se.entity.Customer;
import vn.edu.iuh.fit.se.entity.Order;

@Repository
public interface OrderReponsitory extends JpaRepository<Order, Long> {
}
