package vn.edu.iuh.fit.se;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import vn.edu.iuh.fit.se.entity.Customer;
import vn.edu.iuh.fit.se.reponsitories.CustommerReponsitory;
import vn.edu.iuh.fit.se.services.impl.CustomerServiceImpl;

@SpringBootApplication
public class Lab7MyShopApplication {

    @Autowired
    private CustommerReponsitory custommerReponsitory;

    @Autowired
    private CustomerServiceImpl customerService;



    public static void main(String[] args) {
        SpringApplication.run(Lab7MyShopApplication.class, args);
    }

    @Bean
    public CommandLineRunner lineRunner() {
        return args -> {
            System.out.println("-----START------");
            Customer cus1 = new Customer();
            cus1.setName("Nguyen van A");
            cus1.setPhone("0951753001");
            cus1.setEmail("email01@gmail.com");
            cus1.setAddress("12 phan van tri");


            System.out.println(customerService.insert(cus1));

            System.out.println("------END-------");
        };
    }
}
