package vn.edu.iuh.fit.se.w6.service.impl;

import jakarta.transaction.SystemException;
import jakarta.transaction.TransactionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import vn.edu.iuh.fit.se.w6.entity.Post;
import vn.edu.iuh.fit.se.w6.entity.PostComment;
import vn.edu.iuh.fit.se.w6.reponsitories.PostCommentReponsitory;
import vn.edu.iuh.fit.se.w6.reponsitories.PostReponsitory;
import vn.edu.iuh.fit.se.w6.service.PostCommentSevice;
import vn.edu.iuh.fit.se.w6.service.PostSevice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostCommentSeviceImpl implements PostCommentSevice {

    @Autowired
    private PostCommentReponsitory reponsitory;
    @Autowired
    private TransactionManager transactionManager;

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    public void insert(PostComment item) {
        try {
            transactionManager.begin();
            reponsitory.save(item);
            transactionManager.commit();
        } catch (Exception e) {
            System.out.println("PostCommentSeviceImpl - insert");
            try {
                transactionManager.rollback();
            } catch (SystemException ex) {
                logger.error(ex.getMessage());
                throw new RuntimeException(ex);
            }
            logger.error(e.getMessage());
        }
    }

    @Override
    public void update(PostComment item) {
        try {
            transactionManager.begin();
            reponsitory.save(item);
            transactionManager.commit();
        } catch (Exception e) {
            System.out.println("PostCommentSeviceImpl - edit");
            try {
                transactionManager.rollback();
            } catch (SystemException ex) {
                logger.error(ex.getMessage());
                throw new RuntimeException(ex);
            }
            logger.error(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try {
            transactionManager.begin();
            reponsitory.deleteById(id);
            transactionManager.commit();
        } catch (Exception e) {
            System.out.println("PostCommentSeviceImpl - del");
            try {
                transactionManager.rollback();
            } catch (SystemException ex) {
                logger.error(ex.getMessage());
                throw new RuntimeException(ex);
            }
            logger.error(e.getMessage());
        }
    }

    @Override
    public Optional<PostComment> getById(long id) {
        Optional<PostComment> optionalPost = null;
        try {
            transactionManager.begin();
            optionalPost = reponsitory.findById(id);
            transactionManager.commit();
        } catch (Exception e) {
            System.out.println("PostCommentSeviceImpl - readid");
            try {
                transactionManager.rollback();
            } catch (SystemException ex) {
                logger.error(ex.getMessage());
                throw new RuntimeException(ex);
            }
            logger.error(e.getMessage());
        }

        return optionalPost;
    }

    @Override
    public List<PostComment> getAll() {
        List<PostComment> lst = new ArrayList<>();
        try {
            transactionManager.begin();
            lst = reponsitory.findAll();
            transactionManager.commit();
        } catch (Exception e) {
            System.out.println("PostCommentSeviceImpl - read");
            try {
                transactionManager.rollback();
            } catch (SystemException ex) {
                logger.error(ex.getMessage());
                throw new RuntimeException(ex);
            }
            logger.error(e.getMessage());
        }

        return lst;
    }
}
