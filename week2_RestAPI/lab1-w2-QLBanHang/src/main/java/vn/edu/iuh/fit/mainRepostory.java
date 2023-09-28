package vn.edu.iuh.fit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import vn.edu.iuh.fit.config.Gson_LocalDateTypeAdapter;
import vn.edu.iuh.fit.enums.EmployeeStatus;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.repositories.EmployeeRepository;

import java.time.Instant;
import java.time.LocalDate;

public class mainRepostory {
    public static void main(String[] args) {
        System.out.println("Start ....");

        EmployeeRepository repository = new EmployeeRepository();
        LocalDate localDate = LocalDate.now();

        Employee e1 = new Employee(0,"Nguyen Van A", localDate,
                "email@gmail.com","0951753001", "address 1", EmployeeStatus.IN_ACTIVE);

//        Gson gson = new Gson();

        Gson gson =
                new GsonBuilder()
                        .registerTypeAdapter( LocalDate.class , new Gson_LocalDateTypeAdapter() )
                        .create();

        String result = gson.toJson(e1, Employee.class);
        System.out.println("1- " + result);

        repository.insert(e1);

        System.out.println("End");
    }
}
