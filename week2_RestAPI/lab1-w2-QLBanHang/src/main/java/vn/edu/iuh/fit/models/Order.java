package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.Set;

/***
 * orders (order_id, order_date, emp_id, cust_id)
 */
@Entity
@Table(name = "order")
@Setter
@Getter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Order {
    //orders (order_id, order_date, emp_id, cust_id)
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "order_date")
    private Date orderDate;

    //JPA
    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "cust_id", nullable = false)
    private Customer customer;
//
//    // cach 1:
//    @ManyToMany
//    @JoinTable(name = "order_detail", joinColumns = @JoinColumn(name = "order_id")
//            , inverseJoinColumns = @JoinColumn(name = "product_id"))
//    private Set<Product> productSet;


}
