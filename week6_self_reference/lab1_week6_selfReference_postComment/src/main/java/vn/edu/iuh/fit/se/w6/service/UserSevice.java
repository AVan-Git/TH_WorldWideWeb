package vn.edu.iuh.fit.se.w6.service;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.w6.entity.User;

import java.util.List;
import java.util.Optional;

@Service
public interface UserSevice {
    void insert(User item);
    void update(User item);
    void delete(Long id);
    Optional<User> getById(long id);
    List<User> getAll();

}
