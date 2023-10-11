package vn.edu.iuh.fit.repositores;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.connect.ConnectJpa;
import vn.edu.iuh.fit.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private EntityManager entityManager;
    private EntityTransaction transaction;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ProductRepository() {
        entityManager = ConnectJpa.getInstance().getEntityManager();
        transaction = entityManager.getTransaction();
    }

    public void insert(Product product) {
        try {
            transaction.begin();
            entityManager.persist(product);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("ProductReponsitory - insert");
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }

    public void update(Product product) {
        try {
            transaction.begin();
            entityManager.merge(product);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("ProductReponsitory - update");
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }

    public void delete(long id) {
        try {
            transaction.begin();
            entityManager.remove(entityManager.find(Product.class, id));
            transaction.commit();
        } catch (Exception e) {
            System.out.println("ProductReponsitory - del");
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }
    public Optional<Product> getById (long id) {
        Product prod = null;
        try {
            transaction.begin();
            TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p WHERE p.id=:id", Product.class);
            query.setParameter("id", id);
            prod = query.getSingleResult();
            transaction.commit();
        }catch (Exception e){
            System.out.println("ProductReponsitory - readID");
            transaction.rollback();
            logger.error(e.getMessage());
        }
        return prod == null ? Optional.empty(): Optional.of(prod);
    }
    public List<Product> getAll(){
        List<Product> lst =new ArrayList<>();
        try {
            transaction.begin();
            lst = entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
            transaction.commit();
        }catch (Exception e){
            System.out.println("ProductReponsitory - readAll");
            transaction.rollback();
            logger.error(e.getMessage());
        }
        return lst;
    }
}
