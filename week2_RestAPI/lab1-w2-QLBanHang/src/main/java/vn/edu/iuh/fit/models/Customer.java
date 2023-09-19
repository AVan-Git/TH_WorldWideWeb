package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "customer")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer {
    // customer (cust_id, cust_name, email, phone, address)
    @Id
    @Column(name = "cust_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "cust_name", nullable = false, length = 50)
    private String name;
    @Column(unique = true, length = 50)
    private String email;
    @Column(unique = true, length = 15)
    private String phone;
    @Column(length = 100)
    private String address;


    //JPA
    @OneToMany(mappedBy = "customer")
    private List<Order> lstOrders;

}
