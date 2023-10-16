package vn.edu.iuh.fit.se.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "experience")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
/**
 * kinh nghiem
 */
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id")
    private long id;
    @Column(name = "companyName", nullable = false, length = 120)
    private String company;
    @Column(name = "role", length = 100)
    private String role;
    @Column(name = "work_desc", length = 400)
    private String description;
    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;
    @Column(name = "to_date", nullable = false)
    private LocalDate toDate;


    // JPA
    @ManyToOne
    @JoinColumn(name = "cand_id", nullable = false)
    private Candidate candidate;
}
