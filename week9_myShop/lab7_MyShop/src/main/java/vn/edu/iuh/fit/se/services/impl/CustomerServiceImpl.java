package vn.edu.iuh.fit.se.services.impl;

import jakarta.transaction.SystemException;
import jakarta.transaction.TransactionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.entity.Customer;
import vn.edu.iuh.fit.se.reponsitories.CustommerReponsitory;
import vn.edu.iuh.fit.se.services.CustomerService;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustommerReponsitory reponsitory;

    @Autowired
    private TransactionManager transactionManager;

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());


    @Override
    public boolean insert(Customer item) {
        boolean result = false;
        try {
            transactionManager.begin();
            reponsitory.save(item);
            transactionManager.commit();
            result = true;
        } catch (Exception e) {
            try {
                transactionManager.rollback();
            } catch (SystemException ex) {
                logger.error(ex.getMessage());
                throw new RuntimeException(ex);
            }
            logger.error(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean update(Customer customer) {
        boolean result = false;
        try {
            transactionManager.begin();
            Optional<Customer> optional = reponsitory.findById(customer.getId());
            if (optional.isPresent()) {
                Customer cus = optional.get();
                cus.setAddress(customer.getAddress());
                cus.setEmail(customer.getEmail());
                cus.setName(customer.getName());
                cus.setPhone(customer.getPhone());
                cus.setOrderList(customer.getOrderList());
            } else {
                reponsitory.save(customer);
            }
            transactionManager.commit();
            result = true;
        } catch (Exception e) {
            try {
                transactionManager.rollback();
            } catch (SystemException ex) {
                throw new RuntimeException(ex);
            }
            logger.error(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean delete(long id) {
        boolean result = false;
        try {
            transactionManager.begin();
            reponsitory.deleteById(id);
            transactionManager.commit();
            result = true;
        } catch (Exception e) {
            try {
                transactionManager.rollback();
            } catch (SystemException ex) {
                throw new RuntimeException(ex);
            }
            logger.error(e.getMessage());
        }
        return result;
    }

    @Override
    public Optional<Customer> getById(long id) {
        return reponsitory.findById(id);
    }

    @Override
    public List<Customer> getAll() {
        return reponsitory.findAll();
    }
}
