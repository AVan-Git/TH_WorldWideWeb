package vn.edu.iuh.fit.se.reponsitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.se.entity.Customer;

@Repository
public interface CustommerReponsitory extends JpaRepository<Customer, Long> {
}
