package vn.edu.iuh.fit.repositores;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.connect.ConnectJpa;
import vn.edu.iuh.fit.models.ProductImage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductImageRepository {
    private EntityManager entityManager;
    private EntityTransaction transaction;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ProductImageRepository() {
        entityManager = ConnectJpa.getInstance().getEntityManager();
        transaction = entityManager.getTransaction();
    }
    //
    public  void insert(ProductImage image) {
        try {
            transaction.begin();
            entityManager.persist(image);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("ProductImageReponsitory --- insert: " );
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }
    //
    public void update(ProductImage image) {
        try {
            transaction.begin();
            entityManager.merge(image);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("ProductImageReponsitory - update");
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }

    public void delete(long id) {
        try {
            transaction.begin();
            entityManager.remove(entityManager.find(ProductImage.class, id));
            transaction.commit();
        } catch (Exception e) {
            System.out.println("ProductImageReponsitory - del");
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }
    public Optional<ProductImage> getById (long id) {
        ProductImage prod = null;
        try {
            transaction.begin();
            TypedQuery<ProductImage> query = entityManager.createQuery("SELECT p FROM ProductImage p WHERE p.id=:id", ProductImage.class);
            query.setParameter("id", id);
            prod = query.getSingleResult();
            transaction.commit();
        }catch (Exception e){
            System.out.println("ProductImageReponsitory - readID");
            transaction.rollback();
            logger.error(e.getMessage());
        }
        return prod == null ? Optional.empty(): Optional.of(prod);
    }
    public List<ProductImage> getAll(){
        List<ProductImage> lst =new ArrayList<>();
        try {
            transaction.begin();
            lst = entityManager.createQuery("SELECT p FROM ProductImage p", ProductImage.class).getResultList();
            transaction.commit();
        }catch (Exception e){
            System.out.println("ProductImageReponsitory - readAll");
            transaction.rollback();
            logger.error(e.getMessage());
        }
        return lst;
    }
}
