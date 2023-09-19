package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

/***
 * order_detail (order_id, product_id, quantity, price, note)
 */
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

    // JPA
    // cachs 2 manytomany:  CompositeKey
    @EmbeddedId
    private OrderDetailKey orderDetailKey;
    @ManyToOne
    @MapsId("order_id")
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    private Product product;




}
