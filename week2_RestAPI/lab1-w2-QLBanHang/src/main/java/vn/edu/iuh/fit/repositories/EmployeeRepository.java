package vn.edu.iuh.fit.repositories;

import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.enums.EmployeeStatus;
import vn.edu.iuh.fit.models.Employee;

import java.util.Optional;

public class EmployeeRepository {
    private EntityManager entityManager;
    private EntityTransaction transactionEntity;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public EmployeeRepository() {
        entityManager = Persistence.createEntityManagerFactory("lab_week_2")
                .createEntityManager();

        transactionEntity = entityManager.getTransaction();
    }

    public void insert(Employee employee){
        try {
            transactionEntity.begin();
            entityManager.persist(employee);
            transactionEntity.commit();

        }catch (Exception e)
        {
            System.out.println("err -- "+e);
            transactionEntity.rollback();
            logger.error(e.getMessage());
        }
    }
    //update
    public void setStatus(Employee employee, EmployeeStatus status){
        employee.setStatus(status);
//        update(employee);
    }
    public  void update(Employee employee) {
        try {
            transactionEntity.begin();
            entityManager.merge(employee);
            transactionEntity.commit();

        }catch (Exception e)
        {
            transactionEntity.rollback();
            logger.error(e.getMessage());
        }
    }

    //delete
    public void delete(Employee employee){
        try {
            transactionEntity.begin();
            entityManager.remove(employee);
            transactionEntity.commit();

        }catch (Exception e)
        {
            transactionEntity.rollback();
            logger.error(e.getMessage());
        }
    }

    //getById
    public Optional<Employee> getById(long maTim){
        TypedQuery<Employee> query = entityManager
                .createQuery("SELECT e FROM Employee e WHERE e.id=:id", Employee.class);
        query.setParameter("id", maTim);
        Employee e  = query.getSingleResult();
        return e==null? Optional.empty(): Optional.of(e);
    }
    //getAll
}
