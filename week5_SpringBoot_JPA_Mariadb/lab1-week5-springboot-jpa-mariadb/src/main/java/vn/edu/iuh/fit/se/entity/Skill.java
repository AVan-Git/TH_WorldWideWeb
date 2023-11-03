package vn.edu.iuh.fit.se.entity;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.se.enums.SkillType;

import java.util.List;

@Entity
@Table(name = "skill")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private long id;
    @Column(name = "skill_name", length = 150)
    private String name;
    @Column(name = "skill_desc", length = 300)
    private String description;
    @Column(name = "skill_type" )
    @Enumerated(EnumType.STRING)
    private SkillType type;

    // JPA
    @OneToMany(mappedBy = "skill")
    private List<CandidateSkill> candidateSkillList;

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
//                ", candidateSkillList=" + candidateSkillList +
                '}';
    }
}
