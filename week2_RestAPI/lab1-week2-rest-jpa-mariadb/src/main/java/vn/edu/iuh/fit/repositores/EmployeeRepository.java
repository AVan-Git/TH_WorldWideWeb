package vn.edu.iuh.fit.repositores;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.connect.ConnectJpa;
import vn.edu.iuh.fit.models.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeRepository {
    private EntityManager entityManager;
    private EntityTransaction transaction;

    //dung de thong bao loi
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public EmployeeRepository() {
        entityManager = ConnectJpa.getInstance().getEntityManager();

        transaction = entityManager.getTransaction();
    }

    //insert
    public void insert(Employee employee) {
        try {
            transaction.begin();
            entityManager.persist(employee);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("err --- insert: " + employee);
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }

    //update
    public void update(Employee employee) {
        try {
            transaction.begin();
            entityManager.merge(employee);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("err --- update: " + employee);
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }

    //delete
    public void delete(long maXoa) {
        try {
            transaction.begin();
            entityManager.remove(entityManager.find(Employee.class, maXoa));
            transaction.commit();
        } catch (Exception e) {
            System.out.println("err --- delete: " + maXoa);
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }

    //get One
    public Optional<Employee> findbyId(long id) {
        TypedQuery<Employee> query = entityManager
                .createQuery("SELECT e FROM Employee e WHERE e.id=:id", Employee.class);
        query.setParameter("id", id);
        Employee e = query.getSingleResult();
//        Employee e = entityManager.find(Employee.class, id);
        return e == null ? Optional.empty() : Optional.of(e);
    }
    //getALl
    public List<Employee> getAllEmployee(){
        List<Employee> lst = new ArrayList<>();

        lst = entityManager
                .createNamedQuery("getAllEmployees", Employee.class)
                .getResultList();

        return lst;
    }

}
