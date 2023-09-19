package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "orders")
@Setter
@Getter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Orders {
    //orders (order_id, order_date, emp_id, cust_id)
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @Column(name = "order_date")
    private Date orderDate;


}
