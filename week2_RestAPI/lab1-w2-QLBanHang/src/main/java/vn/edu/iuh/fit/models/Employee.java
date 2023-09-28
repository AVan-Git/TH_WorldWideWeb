package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.enums.EmployeeStatus;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long id;

    @Column(name = "full_name", length = 150, nullable = false)
    private String fullname;
    @Column(nullable = false)
    private LocalDate dob;// ngaySinh
    @Column(unique = true, length = 100, nullable = true) // unique: độc nhất
    private String email;
    @Column(unique = true, length = 15, nullable = true)
    private String phone;
    @Column(length = 255, nullable = false)
    private String address;
    @Column(nullable = false)
    private EmployeeStatus status;

    // JPA
    @OneToMany(mappedBy = "employee")
    private List<Order> lstOrder;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public Employee(long id, String fullname, LocalDate dob, String email, String phone, String address, EmployeeStatus status) {
        this.id = id;
        this.fullname = fullname;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", fullname='" + fullname + '\'' + ", dob=" + dob + ", email='" + email + '\'' + ", phone='" + phone + '\'' + ", address='" + address + '\'' + ", status=" + status + '}';
    }
}
