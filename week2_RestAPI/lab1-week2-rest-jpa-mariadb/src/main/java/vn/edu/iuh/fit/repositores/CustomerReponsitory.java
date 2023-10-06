package vn.edu.iuh.fit.repositores;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.connect.ConnectJpa;

public class CustomerReponsitory {
    private EntityManager entityManager;
    private EntityTransaction transaction;

    private  final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public CustomerReponsitory() {
        entityManager = ConnectJpa.getInstance().getEntityManager();

        transaction = entityManager.getTransaction();
    }
}
