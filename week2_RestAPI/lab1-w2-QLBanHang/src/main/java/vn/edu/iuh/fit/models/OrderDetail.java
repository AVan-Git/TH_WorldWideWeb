package vn.edu.iuh.fit.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "order_detail")
@Setter
@Getter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    // order_detail (order_id, product_id, quantity, price, note)
    @Column(nullable = false)
    private int quantity; // so luong
    @Column(nullable = false)
    private double price;
    private String note;


}
