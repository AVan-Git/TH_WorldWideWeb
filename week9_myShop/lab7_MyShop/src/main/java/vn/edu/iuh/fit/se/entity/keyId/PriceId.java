package vn.edu.iuh.fit.se.entity.keyId;

import jakarta.persistence.*;
import vn.edu.iuh.fit.se.entity.Product;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceId priceId = (PriceId) o;
        return Objects.equals(product, priceId.product) && Objects.equals(price_date_time, priceId.price_date_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, price_date_time);
    }
}
