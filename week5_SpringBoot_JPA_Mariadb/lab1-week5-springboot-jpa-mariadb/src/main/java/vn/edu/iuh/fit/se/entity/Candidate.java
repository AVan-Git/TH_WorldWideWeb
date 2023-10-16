package vn.edu.iuh.fit.se.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "candidate")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Candidate {// ung vien
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cand_id")
    private long id;
    @Column(name = "full_name", nullable = false)
    private String name;
    @Column(name = "dob")
    private LocalDate dob;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "phone", unique = true)
    private String phone;

    //JPA
    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @JoinColumn(name = "address")
    private Address address;

    @OneToMany(mappedBy = "candidate")
    private List<Experience> experiences;

}
