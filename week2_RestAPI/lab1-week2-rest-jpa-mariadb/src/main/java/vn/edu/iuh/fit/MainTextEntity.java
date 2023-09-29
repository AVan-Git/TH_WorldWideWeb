package vn.edu.iuh.fit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.enums.EmployeeStatus;
import vn.edu.iuh.fit.enums.ProductStatus;
import vn.edu.iuh.fit.models.Customer;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.models.ProductImage;

import java.sql.Date;
import java.time.LocalDate;

public class MainTextEntity {

    public static void main(String[] args) {

        LocalDate date = LocalDate.of(2020, 1, 8);
        Employee emp = new Employee();
        emp.setName("Nguyen Van 1");
        emp.setEmail("email@gmail.com");
        emp.setPhone("0951753001");
        emp.setDob(date);
        emp.setAddress("12 phan co ich");
        emp.setStatus(EmployeeStatus.IN_ACTIVE);

        Product pro1 = new Product();
        pro1.setName("Banh gao 1");
        pro1.setUnit("don vi 1");
        pro1.setDescription("Mo ta 1");
        pro1.setManufacturerName("NSX Banh VN");
        pro1.setStatus(ProductStatus.IN_ACTIVE);

        Customer cus = new Customer();
        cus.setName("Tran binh");
        cus.setEmail("Binh@gmail.com");
        cus.setPhone("0951753002");
        cus.setAddress("12 phan co ich");

        ProductImage image = new ProductImage();
        image.setPath("https://picsum.photos/id/2/200/200");
        image.setAlternative("product image");


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(image);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
