package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Customer {
    public Customer(Long id, String name) {
        this.id = id;
        this.full_name = name;
    }

    public Customer() {
    }

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name")
    private String full_name;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + full_name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String name) {
        this.full_name = name;
    }
}
