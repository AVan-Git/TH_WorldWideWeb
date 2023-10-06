package vn.edu.iuh.fit.repositores;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.connect.ConnectJpa;
import vn.edu.iuh.fit.models.Order;
import vn.edu.iuh.fit.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepository {
    private EntityManager entityManager;
    private EntityTransaction transaction;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public OrderRepository() {
        entityManager = ConnectJpa.getInstance().getEntityManager();
        transaction = entityManager.getTransaction();
    }

    public void insert(Order order) {
        try {
            transaction.begin();
            entityManager.persist(order);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("OrderRepository - insert");
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }

    public void update(Order order) {
        try {
            transaction.begin();
            entityManager.merge(order);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("OrderRepository - update");
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }

    public void delete(long id) {
        try {
            transaction.begin();
            entityManager.remove(entityManager.find(Order.class, id));
            transaction.commit();
        } catch (Exception e) {
            System.out.println("OrderRepository - del");
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }
    public Optional<Order> getById (long id) {
        Order order = null;
        try {
            transaction.begin();
            TypedQuery<Order> query = entityManager.createQuery("SELECT p FROM Order p WHERE p.id=:id", Order.class);
            query.setParameter("id", id);
            order = query.getSingleResult();
            transaction.commit();
        }catch (Exception e){
            System.out.println("OrderRepository - readID");
            transaction.rollback();
            logger.error(e.getMessage());
        }
        return order == null ? Optional.empty(): Optional.of(order);
    }
    public List<Order> getAll(){
        List<Order> lst =new ArrayList<>();
        try {
            transaction.begin();
            lst = entityManager.createQuery("SELECT p FROM Order p", Order.class).getResultList();
            transaction.commit();
        }catch (Exception e){
            System.out.println("OrderRepository - readAll");
            transaction.rollback();
            logger.error(e.getMessage());
        }
        return lst;
    }
}
