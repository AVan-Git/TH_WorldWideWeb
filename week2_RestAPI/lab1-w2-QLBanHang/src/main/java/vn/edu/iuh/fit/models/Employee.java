package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.enums.EmployeeStatus;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee")
@Setter
@Getter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
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

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public Employee(final long id, final String fullname, final LocalDate dob, final String email,
                    final String phone, final String address, final EmployeeStatus status) {
        this.id = id;
        this.fullname = fullname;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                '}';
    }
}
