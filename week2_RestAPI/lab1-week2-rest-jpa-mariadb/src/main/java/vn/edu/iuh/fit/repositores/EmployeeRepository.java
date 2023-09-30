package vn.edu.iuh.fit.repositores;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.connect.ConnectJpa;

public class EmployeeRepository {
    private EntityManager entityManager;
    private EntityTransaction transaction;

    public EmployeeRepository() {
        entityManager = ConnectJpa.getInstance().getEntityManager();

        transaction = entityManager.getTransaction();
    }

}
