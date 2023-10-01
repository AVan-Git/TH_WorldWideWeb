package vn.edu.iuh.fit.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

/**
 * bị lỗi rồi - fix đi
 */
@Embeddable
public class OrderDetailKey implements Serializable {
    @Column(name = "order_id")
    private long orderId;

    @Column(name = "product_id")
    private long productId;

    public OrderDetailKey() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailKey that = (OrderDetailKey) o;
        return orderId == that.orderId && productId == that.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId);
    }
}
