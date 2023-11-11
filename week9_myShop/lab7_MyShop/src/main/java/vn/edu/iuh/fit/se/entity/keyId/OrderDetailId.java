package vn.edu.iuh.fit.se.entity.keyId;

import vn.edu.iuh.fit.se.entity.Order;
import vn.edu.iuh.fit.se.entity.Product;

import java.io.Serializable;
import java.util.Objects;

public class OrderDetailId implements Serializable {

    private Order order;

    private Product product;

    //


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailId that = (OrderDetailId) o;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public OrderDetailId() {
    }

    public OrderDetailId(Order order, Product product) {
        this.order = order;
        this.product = product;
    }
}
