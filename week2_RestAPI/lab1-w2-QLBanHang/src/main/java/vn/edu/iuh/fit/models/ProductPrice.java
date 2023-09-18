package vn.edu.iuh.fit.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "product_price")
public class ProductPrice {
    @Id @Column(name = "price_date_time", nullable = false)
    private Date priceDateTime;

    @Column(nullable = true, length = 255)
    private String note;

    @Column(nullable = false)
    private double price;


    @Override
    public String toString() {
        return "ProductPrice{" +
                "priceDateTime=" + priceDateTime +
                ", note='" + note + '\'' +
                ", price=" + price +
                '}';
    }

    public Date getPriceDateTime() {
        return priceDateTime;
    }

    public void setPriceDateTime(Date priceDateTime) {
        this.priceDateTime = priceDateTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductPrice(Date priceDateTime, String note, double price) {
        this.priceDateTime = priceDateTime;
        this.note = note;
        this.price = price;
    }

    public ProductPrice() {
    }
}
