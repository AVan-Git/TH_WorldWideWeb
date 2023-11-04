package vn.edu.iuh.fit.se.entity.keyId;

import jakarta.persistence.*;
import vn.edu.iuh.fit.se.entity.Product;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PriceId implements Serializable {

    private Product product;
    private LocalDateTime price_date_time;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDateTime getPrice_date_time() {
        return price_date_time;
    }

    public void setPrice_date_time(LocalDateTime price_date_time) {
        this.price_date_time = price_date_time;
    }

    public PriceId(Product product, LocalDateTime price_date_time) {
        this.product = product;
        this.price_date_time = price_date_time;
    }

    public PriceId() {
    }
}
