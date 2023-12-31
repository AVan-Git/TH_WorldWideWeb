package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * product_price (product_id, price_date_time, price, note)
 */

@Entity
@Table(name = "product_price")
public class ProductPrice {
    @Id
    @Column(name = "price_date_time")
    private LocalDateTime priceDateTime;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "note")
    private String note;

    //JPA
    @ManyToOne
    @JoinColumn(name = "product_id",unique = false,nullable = true)
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductPrice(LocalDateTime priceDateTime, double price, String note) {
        this.priceDateTime = priceDateTime;
        this.price = price;
        this.note = note;
    }

    public ProductPrice() {
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "priceDateTime=" + priceDateTime +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }

    public LocalDateTime getPriceDateTime() {
        return priceDateTime;
    }

    public void setPriceDateTime(LocalDateTime priceDateTime) {
        this.priceDateTime = priceDateTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
