package vn.edu.iuh.fit.se.w6.service.impl;

import jakarta.transaction.SystemException;
import jakarta.transaction.TransactionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import vn.edu.iuh.fit.se.w6.entity.User;
import vn.edu.iuh.fit.se.w6.reponsitories.UserReponsitory;
import vn.edu.iuh.fit.se.w6.service.UserSevice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserSeviceImpl implements UserSevice {

    @Autowired
    private UserReponsitory reponsitory;
    @Autowired
    private TransactionManager transactionManager;

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    public void insert(User item) {
        try {
            transactionManager.begin();
            reponsitory.save(item);
            transactionManager.commit();
        } catch (Exception e) {
            System.out.println("UserSeviceImpl - insert");
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
    public void update(User item) {
        try {
            transactionManager.begin();
            reponsitory.save(item);
            transactionManager.commit();
        } catch (Exception e) {
            System.out.println("UserSeviceImpl - insert");
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
            System.out.println("UserSeviceImpl - insert");
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
    public Optional<User> getById(long id) {
        Optional<User> optionalUser = null;
        try {
            transactionManager.begin();
            optionalUser = reponsitory.findById(id);
            transactionManager.commit();
        } catch (Exception e) {
            System.out.println("UserSeviceImpl - insert");
            try {
                transactionManager.rollback();
            } catch (SystemException ex) {
                logger.error(ex.getMessage());
                throw new RuntimeException(ex);
            }
            logger.error(e.getMessage());
        }

        return optionalUser;
    }

    @Override
    public List<User> getAll() {
        List<User> lst = new ArrayList<>();
        try {
            transactionManager.begin();
            lst = reponsitory.findAll();
            transactionManager.commit();
        } catch (Exception e) {
            System.out.println("UserSeviceImpl - insert");
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
