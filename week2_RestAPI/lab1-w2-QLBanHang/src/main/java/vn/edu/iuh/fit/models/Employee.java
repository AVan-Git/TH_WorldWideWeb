package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.enums.EmployeeStatus;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "employee")
@Setter
@Getter
@ToString
@AllArgsConstructor
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
    private Date dob;// ngaySinh
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

}
