package vn.edu.iuh.fit.se;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vn.edu.iuh.fit.se.entity.Person;
import vn.edu.iuh.fit.se.entity.Student;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start...");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Student st1 = context.getBean("student1", Student.class);
        Student st2 = context.getBean("student2", Student.class);
        System.out.println(st1);
        System.out.println(st2);

        Person person = context.getBean("person1", Person.class);

        System.out.println(person);



        System.out.println("... END");

    }
}