package vn.edu.iuh.fit.se.w6.reponsitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.se.w6.entity.User;

@Repository
public interface UserReponsitory extends JpaRepository<User, Long> {
}
