package vn.edu.iuh.fit.se.w6.service;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.w6.entity.PostComment;

import java.util.List;
import java.util.Optional;

@Service
public interface PostCommentSevice {
    void insert(PostComment item);
    void update(PostComment item);
    void delete(Long id);
    Optional<PostComment> getById(long id);
    List<PostComment> getAll();

}
