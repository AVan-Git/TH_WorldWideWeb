package vn.edu.iuh.fit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.enums.EmployeeStatus;
import vn.edu.iuh.fit.models.Employee;

public class MainTextEntity {

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("Nguyen Van 1");
        emp.setEmail("email@gmail.com");
        emp.setPhone("0951753001");
        emp.setAddress("12 phan co ich");
        emp.setStatus(EmployeeStatus.IN_ACTIVE);


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(emp);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
