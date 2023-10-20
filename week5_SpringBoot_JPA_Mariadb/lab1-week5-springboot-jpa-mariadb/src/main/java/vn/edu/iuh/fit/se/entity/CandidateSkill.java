package vn.edu.iuh.fit.se.entity;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.se.entity.key.CandidateSkillKey;
import vn.edu.iuh.fit.se.enums.SkillLevel;

@Entity
@Table(name = "candidate_skill")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@IdClass(CandidateSkillKey.class)
public class CandidateSkill {
    @Column(name = "skill_level", nullable = false)
    private SkillLevel skillLevel;
    @Column(name = "more_info", length = 1000)
    private String moreInfo;

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cand_id")
    private Candidate candidate;
    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_id")
    private Skill skill;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Override
    public String toString() {
        return "CandidateSkill{" +
                "skillLevel=" + skillLevel.getLevel() +
                ", moreInfo='" + moreInfo + '\'' +
                ", candidate=" + candidate.getId() +
                ", skill=" + skill.getId() +
                ", id=" + id +
                '}';
    }
}
