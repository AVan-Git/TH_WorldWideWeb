package vn.edu.iuh.fit.se.entity;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.se.entity.key.CandidateSkillKey;
import vn.edu.iuh.fit.se.enums.SkillLevel;
@Entity
@Table(name = "candidate_skill")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@IdClass(CandidateSkillKey.class)
public class CandidateSkill {

    private SkillLevel skillLevel;
    private String moreInfo;

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cand_id")
    private Candidate candidate;
    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_id")
    private Skill skill;
}
