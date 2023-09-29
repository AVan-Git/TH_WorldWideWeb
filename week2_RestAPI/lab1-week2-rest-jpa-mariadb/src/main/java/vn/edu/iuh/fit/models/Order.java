package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

/**
 * orders (order_id, order_date, emp_id, cust_id)
 */

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private long id;
    @Column(name = "order_date")
    private LocalDate orderDate;

    //JPA
    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "cust_id", nullable = false)
    private Customer customer;

//    @ManyToMany
//    @JoinTable(name = "order_detail", joinColumns = @JoinColumn(name = "order_id"),
//        inverseJoinColumns =@JoinColumn(name = "product_id") )
//    private List<Product> lstProduct;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Order() {
    }

    public Order(long id, LocalDate orderDate) {
        this.id = id;
        this.orderDate = orderDate;
    }
}
