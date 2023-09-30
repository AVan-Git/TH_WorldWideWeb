import entity.Course;
import entity.CourseRegistration;
import entity.Customer;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Customer emp = new Customer();
        emp.setFull_name("Nguyen Van 4");

        Course course = new Course();
        course.setName("course 1");

        Student student = new Student();
        student.setName("student - 1");

        CourseRegistration registration = new CourseRegistration();
        registration.setCourse(course);
        registration.setStudent(student);
        registration.setGrade(12);

        EntityManagerFactory  entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.persist(course);
        entityManager.persist(registration);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();


    }

}
