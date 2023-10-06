package vn.edu.iuh.fit.repositores;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.connect.ConnectJpa;
import vn.edu.iuh.fit.models.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private EntityManager entityManager;
    private EntityTransaction transaction;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public CustomerRepository() {
        entityManager = ConnectJpa.getInstance().getEntityManager();

        transaction = entityManager.getTransaction();
    }

    // insert
    public void insert(Customer customer) {
        try {
            transaction.begin();
            entityManager.persist(customer);
            transaction.commit();

        } catch (Exception e) {
            System.err.println("Reponsitory - Custom - insert() - " + customer);
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }

    //update
    public void update(Customer custom) {
        try {
            transaction.begin();
            entityManager.merge(custom);
            transaction.commit();

        } catch (Exception e) {
            System.err.println("Reponsitory - Custom - update() - " + custom);
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }

    // delete
    public void delete(long idXoa) {
        try {
            transaction.begin();
            entityManager.remove(entityManager.find(Customer.class, idXoa));
            transaction.commit();
        } catch (Exception e) {
            System.err.println("Reponsitory - Custom - del() - " + idXoa);
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }

    // findById
    public Optional<Customer> getById(long id) {
        Customer cus = null;
        String sql = "SELECT cus FROM Customer cus WHERE cus.id=:id";

        try {
            transaction.begin();
            TypedQuery<Customer>
                    query = entityManager.createQuery(sql, Customer.class);
            query.setParameter("id", id);
            cus = query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            System.err.println("Reponsitory - Custom - Read() - " + id);
            transaction.rollback();
            logger.error(e.getMessage());
        }
        return cus == null ? Optional.empty():Optional.of(cus);
    }
    // findAll
    public List<Customer>  getAll(){
        List<Customer> lst = new ArrayList<>();
        try {
            transaction.begin();
            lst = entityManager.createQuery("SELECT cus FROM Customer cus", Customer.class).getResultList();
            transaction.commit();
        }catch (Exception e)
        {
            System.err.println("Reponsitory  -- Customer -- getALl");
            transaction.rollback();
            logger.error(e.getMessage());
        }

        return lst;
    }
}
