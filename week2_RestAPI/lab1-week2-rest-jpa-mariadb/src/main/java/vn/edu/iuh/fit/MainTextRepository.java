package vn.edu.iuh.fit;

import vn.edu.iuh.fit.enums.EmployeeStatus;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.repositores.EmployeeRepository;

import java.time.LocalDate;
import java.util.Optional;

public class MainTextRepository {
    public static void main(String[] args) {
        System.out.println("Start...");
        EmployeeRepository employeeRepository = new EmployeeRepository();

        LocalDate date = LocalDate.of(2020, 1, 8);
        Employee emp = new Employee();
        emp.setName("Nguyen Van 3");
        emp.setEmail("email3@gmail.com");
        emp.setPhone("0951753103");
        emp.setDob(date);
        emp.setAddress("12 phan co ich");
        emp.setStatus(EmployeeStatus.TERMINATE);
        emp.setId(101L);

//        employeeRepository.insert(emp);
//        Optional<Employee> e1 = employeeRepository.findbyId(101L);
//        if (e1.isPresent()){
//            System.out.println(e1);
//        }
//        else {
//            System.err.println("employeeRepository.findbyId(1L)");
//        }
//        employeeRepository.update(emp);
//        employeeRepository.getAllEmployee().forEach(System.out::println);
            employeeRepository.delete(emp.getId());
        System.out.println("...END.");
    }
}
