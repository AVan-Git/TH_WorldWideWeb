package vn.edu.iuh.fit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.enums.EmployeeStatus;
import vn.edu.iuh.fit.enums.ProductStatus;
import vn.edu.iuh.fit.models.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

//        Product pro1 = new Product();
//        pro1.setName("Banh gao 1");
//        pro1.setUnit("don vi 1");
//        pro1.setDescription("Mo ta 1");
//        pro1.setManufacturerName("NSX Banh VN");
//        pro1.setStatus(ProductStatus.IN_ACTIVE);

        Customer cus = new Customer();
        cus.setName("Tran binh");
        cus.setEmail("Binh@gmail.com");
        cus.setPhone("0951753002");
        cus.setAddress("12 phan co ich");

//
        ProductImage image = new ProductImage();
        image.setId(12L);
        image.setPath("https://picsum.photos/id/2/200/200");
        image.setAlternative("product image");

        ProductImage image1 = new ProductImage();
        image1.setId(123L);
        image1.setPath("https://picsum.photos/id/3/200/200");
        image1.setAlternative("product image 2");

        // test JPA
        Product pro2 = new Product();
        pro2.setName("Banh gao 1");
        pro2.setUnit("don vi 1");
        pro2.setDescription("Mo ta 1");
        pro2.setManufacturerName("NSX Banh VN");
        pro2.setStatus(ProductStatus.IN_ACTIVE);
        List<ProductImage> lst = new ArrayList<>();
        image.setProduct(pro2);
        lst.add(image);
        image1.setProduct(pro2);
        lst.add(image1);
        pro2.setProductImages(lst);

        // Order
        Order order = new Order();
        order.setOrderDate(date);
        order.setCustomer(cus);
        order.setEmployee(emp);



        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(emp);
        entityManager.persist(cus);
        entityManager.persist(order);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
