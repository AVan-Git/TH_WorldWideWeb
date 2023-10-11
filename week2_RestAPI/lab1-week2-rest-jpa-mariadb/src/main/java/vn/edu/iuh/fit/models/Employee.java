package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.enums.EmployeeStatus;

import java.time.LocalDate;
import java.util.List;

/**
 * employee (emp_id, full_name, dob, email, phone, address, status)
 */
@Entity
@Table(name = "employee")
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "getAllEmployees",
                query = "SELECT * FROM employee",
                resultClass = Employee.class
        )
})
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "emp_id")
    private long id;
    @Column(name = "full_name", nullable = false, length = 150)
    private String name;
    @Column(name = "dob")
    private LocalDate dob;
    @Column(name = "email",length = 50, unique = true) //unique: su doc nhat
    private String email;
    @Column(name = "phone",length = 15, unique = true) //unique: su doc nhat
    private String phone;
    @Column(name = "address",length = 255)
    private String address;
    @Column(name = "status",nullable = false)
    private EmployeeStatus status;

    //JPA
    @OneToMany(mappedBy = "employee")
    private List<Order> lstOrder;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public Employee() {
    }

    public Employee(long id, String name, LocalDate dob, String email, String phone, String address, EmployeeStatus status) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }
}
