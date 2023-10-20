package vn.edu.iuh.fit.se.entity;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.se.enums.CountryCode;

@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Address {
    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "city", length = 50)
    private String city;
    @Column(name = "country")
    private CountryCode country;
    @Column(name = "zip_code", length = 7)
    private String zipCode;
    @Column(name = "street", length = 150)
    private String street;
    @Column(name = "number", length = 20)
    private String number;

    //JPA
    @OneToOne(mappedBy = "address")
    private Company company;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Candidate candidate;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", country='" + country.getCountryCode() + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
