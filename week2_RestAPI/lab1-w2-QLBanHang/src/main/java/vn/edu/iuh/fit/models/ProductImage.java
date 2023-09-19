package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

/***
 * product_image (product_id, image_id, path, alternative)
 */
@Entity
@Table(name = "product_image")
@Setter
@Getter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class ProductImage {
    //product_image (product_id, image_id, path, alternative)
    @Id
    @Column(name = "image_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String path;// link|| src
    @Column(nullable = false)
    private String alternative; // alt

    // JPA
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private  Product product;

}
