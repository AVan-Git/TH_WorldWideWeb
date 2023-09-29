package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

/**
 * product_image (product_id, image_id, path, alternative)
 *
 */
@Entity
@Table(name = "product_image")
public class ProductImage {
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private long id;
    @Column(name = "path", nullable = false)
    private String path; // src
    @Column(name = "alternative", nullable = false)
    private String alternative;

    //JPA


    @Override
    public String toString() {
        return "ProductImage{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", alternative='" + alternative + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public ProductImage() {
    }

    public ProductImage(long id, String path, String alternative) {
        this.id = id;
        this.path = path;
        this.alternative = alternative;
    }
}
