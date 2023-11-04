package vn.edu.iuh.fit.se.w6.service;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.w6.entity.Post;

import java.util.List;
import java.util.Optional;

@Service
public interface PostSevice {
    void insert(Post item);
    void update(Post item);
    void delete(Long id);
    Optional<Post> getById(long id);
    List<Post> getAll();

}
