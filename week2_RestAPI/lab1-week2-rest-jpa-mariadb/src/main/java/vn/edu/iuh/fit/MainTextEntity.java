package vn.edu.iuh.fit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.enums.EmployeeStatus;
import vn.edu.iuh.fit.enums.ProductStatus;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.models.Product;

public class MainTextEntity {

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("Nguyen Van 1");
        emp.setEmail("email@gmail.com");
        emp.setPhone("0951753001");
        emp.setAddress("12 phan co ich");
        emp.setStatus(EmployeeStatus.IN_ACTIVE);

        Product pro1 = new Product();
        pro1.setName("Banh gao 1");
        pro1.setUnit("don vi 1");
        pro1.setDescription("Mo ta 1");
        pro1.setManufacturerName("NSX Banh VN");
        pro1.setStatus(ProductStatus.IN_ACTIVE);


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(pro1);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
