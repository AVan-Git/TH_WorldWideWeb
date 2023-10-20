package vn.edu.iuh.fit.se.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "company")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comp_id")
    private long id;
    @Column(name = "comp_name", nullable = false)
    private String name;
    @Column(name = "web_url")
    private String webUrl;
    @Column(name = "email",unique = true)
    private String email;
    @Column(name = "phone", unique = true)
    private String phone;
    @Column(name = "about", length = 2000)
    private String about;

    //JPA
    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @JoinColumn(name = "address")
    private Address address;

    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", webUrl='" + webUrl + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", about='" + about + '\'' +
                ", address=" + address +
                '}';
    }
}
