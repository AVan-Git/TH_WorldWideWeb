package vn.edu.iuh.fit.se;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.edu.iuh.fit.se.entity.Address;
import vn.edu.iuh.fit.se.entity.Candidate;
import vn.edu.iuh.fit.se.enums.CountryCode;
import vn.edu.iuh.fit.se.repositories.AddressRepository;
import vn.edu.iuh.fit.se.service.impl.CandidateServiceImpl;

import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
public class Lab1Week5SpringbootJpaMariadbApplication {

    @Autowired
    private CandidateServiceImpl candidateService;
    @Autowired
    private AddressRepository addressRepository;

    public static void main(String[] args) {
        SpringApplication.run(Lab1Week5SpringbootJpaMariadbApplication.class, args);
    }

//    @Bean
    public CommandLineRunner sampleRecord(){
        return  args -> {
            System.out.println("-----START-----");

            Random random = new Random();
            int rd_country ;
            int i = 1;
            for (; i < 1000; i++) {
                Address ar = new Address();
                ar.setCity("TP HCM");
                ar.setNumber(random.nextInt(1,100) + "");
                ar.setStreet("Phan co ich "+i);
                ar.setZipCode(random.nextInt(70000,80000) + "");
                ar.setCountry(CountryCode.VN);
                rd_country = random.nextInt(1,10);
                if (rd_country == 6)
                {
                  ar.setCountry(CountryCode.THA);
                }
                if (rd_country == 5)
                {
                    ar.setCountry(CountryCode.LAO);
                }
//                addressRepository.save(ar);

                Candidate candidate = new Candidate();
                candidate.setAddress(ar);
                candidate.setDob(LocalDate.of(random.nextInt(1950,2002), random.nextInt(1,12), random.nextInt(1,29)));
                candidate.setName("name #"+i);
                candidate.setEmail("email"+i +"@gmail.com");
                candidate.setPhone(random.nextLong(1000000000L,9999999999L) + "");

                candidateService.insert(candidate);


                System.out.println(candidate);

            }

            candidateService.findAll().forEach(System.out::println);
            System.out.println("-----END-----");
        };
    }




}
