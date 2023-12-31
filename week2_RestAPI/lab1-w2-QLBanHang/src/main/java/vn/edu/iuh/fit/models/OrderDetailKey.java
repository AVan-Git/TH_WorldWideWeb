package vn.edu.iuh.fit.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

/***
 * cachs 2 manytomany:  CompositeKey
 */

@Embeddable
public class OrderDetailKey implements Serializable {
    @Column(name = "order_id")
    private long orderId;
    @Column(name = "product_id")
    private long productId;
}
