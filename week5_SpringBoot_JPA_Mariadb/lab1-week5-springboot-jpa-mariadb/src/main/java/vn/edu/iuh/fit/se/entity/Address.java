package vn.edu.iuh.fit.se.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Address {
    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "city", length = 50, nullable = false)
    private String city;
    @Column(name = "address_id", length = 6, nullable = false)
    private String country;
    @Column(name = "address_id", length = 7)
    private String zipCode;
    @Column(name = "address_id", length = 150)
    private String street;
    @Column(name = "address_id", length = 20)
    private String number;

    //JPA
    @OneToOne(mappedBy = "address")
    private Company company;

    @OneToOne(mappedBy = "address")
    private Candidate candidate;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
