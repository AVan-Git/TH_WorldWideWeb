package vn.edu.iuh.fit.repositores;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.connect.ConnectJpa;
import vn.edu.iuh.fit.models.Order;
import vn.edu.iuh.fit.models.OrderDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderDetailRepository {
    private EntityManager entityManager;
    private EntityTransaction transaction;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public OrderDetailRepository() {
        entityManager = ConnectJpa.getInstance().getEntityManager();
        transaction = entityManager.getTransaction();
    }

    public void insert(OrderDetail orderDetail) {
        try {
            transaction.begin();
            entityManager.persist(orderDetail);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("OrderDetailRepository - insert");
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }

    public void update(OrderDetail orderDetail) {
        try {
            transaction.begin();
            entityManager.merge(orderDetail);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("OrderDetailRepository - update");
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }

    public void delete(long id) {
        try {
            transaction.begin();
            entityManager.remove(entityManager.find(OrderDetail.class, id));
            transaction.commit();
        } catch (Exception e) {
            System.out.println("OrderDetailRepository - del");
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }
    public Optional<OrderDetail> getById (long id) {
        OrderDetail orderDetail = null;
        try {
            transaction.begin();
            TypedQuery<OrderDetail> query = entityManager.createQuery("SELECT o FROM OrderDetail o WHERE o.id=:id", OrderDetail.class);
            query.setParameter("id", id);
            orderDetail = query.getSingleResult();
            transaction.commit();
        }catch (Exception e){
            System.out.println("OrderDetailRepository - readID");
            transaction.rollback();
            logger.error(e.getMessage());
        }
        return orderDetail == null ? Optional.empty(): Optional.of(orderDetail);
    }
    public List<OrderDetail> getAll(){
        List<OrderDetail> lst =new ArrayList<>();
        try {
            transaction.begin();
            lst = entityManager.createQuery("SELECT o FROM OrderDetail o", OrderDetail.class).getResultList();
            transaction.commit();
        }catch (Exception e){
            System.out.println("OrderDetailRepository - readAll");
            transaction.rollback();
            logger.error(e.getMessage());
        }
        return lst;
    }
}
