package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.util.List;

/**
 * customer (cust_id, cust_name, email, phone, address)
 *
 * -- Long - String - String - String - String -
 *
 * -- Customer(long id, String name, String email, String phone, String address)
 */
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "cust_id")
    private long id;
    @Column(name = "cust_name", nullable = false)
    private String name;
    @Column(name = "email", unique = true, length = 50)
    private String email;
    @Column(name = "phone", unique = true, length = 15)
    private String phone;
    @Column(name = "address")
    private String address;

    //JPA
    @OneToMany(mappedBy = "customer")
    private List<Order> lstOrders;


    public Customer() {
    }

    public Customer(long id, String name, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
