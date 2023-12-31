package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.enums.ProductStatus;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
@ToString
@Getter
@Setter
@AllArgsConstructor // constructor All
@NoArgsConstructor// constructor k co bien
@RequiredArgsConstructor // constructor tuy bien
public class Product {

    //product_id, name, description, unit, manufacturer_name, status
    @Id @Column(name = "product_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = true, length = 255)
    private String description; // mô tả
    private String unit;// don vi
    @Column(name = "manufacturer_name")
    private String manufacturerName;// tên nhà sản suất
    @Column(nullable = false)
    private ProductStatus status;

    // JPA
//
//    //Cach 1 manytomany
//    @ManyToMany(mappedBy = "productSet")
//    private Set<Order> orderSet;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages;

    @OneToMany(mappedBy = "product2")
    private List<ProductPrice> productPrices;

}
