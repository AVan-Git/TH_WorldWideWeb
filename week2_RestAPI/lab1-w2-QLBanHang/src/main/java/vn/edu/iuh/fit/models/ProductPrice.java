package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "product_price")
@Setter
@Getter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class ProductPrice {
    @Id @Column(name = "price_date_time", nullable = false)
    private Date priceDateTime;

    @Column(nullable = true, length = 255)
    private String note;

    @Column(nullable = false)
    private double price;

    // JPA
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private  Product product2;
}
