package vn.edu.iuh.fit.repositores;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.connect.ConnectJpa;
import vn.edu.iuh.fit.models.ProductImage;
import vn.edu.iuh.fit.models.ProductPrice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductPriceReponsitory {
    private EntityManager entityManager;
    private EntityTransaction transaction;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ProductPriceReponsitory() {
        entityManager = ConnectJpa.getInstance().getEntityManager();
        transaction = entityManager.getTransaction();
    }
    //
    public  void insert(ProductPrice price) {
        try {
            transaction.begin();
            entityManager.persist(price);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("ProductPriceReponsitory --- insert: " );
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }
    //
    public void update(ProductPrice price) {
        try {
            transaction.begin();
            entityManager.merge(price);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("ProductPriceReponsitory - update");
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }

    public void delete(LocalDateTime id) {
        try {
            transaction.begin();
            entityManager.remove(entityManager.find(ProductPrice.class, id));
            transaction.commit();
        } catch (Exception e) {
            System.out.println("ProductPriceReponsitory - del");
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }
    public Optional<ProductPrice> getById (LocalDateTime id) {
        ProductPrice prod = null;
        try {
            transaction.begin();
            TypedQuery<ProductPrice> query = entityManager.createQuery("SELECT p FROM ProductPrice p WHERE p.priceDateTime=:id", ProductPrice.class);
            query.setParameter("id", id);
            prod = query.getSingleResult();
            transaction.commit();
        }catch (Exception e){
            System.out.println("ProductPriceReponsitory - readID");
            transaction.rollback();
            logger.error(e.getMessage());
        }
        return prod == null ? Optional.empty(): Optional.of(prod);
    }
    public List<ProductPrice> getAll(){
        List<ProductPrice> lst =new ArrayList<>();
        try {
            transaction.begin();
            lst = entityManager.createQuery("SELECT p FROM ProductPrice p", ProductPrice.class).getResultList();
            transaction.commit();
        }catch (Exception e){
            System.out.println("ProductPriceReponsitory - readAll");
            transaction.rollback();
            logger.error(e.getMessage());
        }
        return lst;
    }
}
