package vn.edu.iuh.fit.se.entity;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.se.entity.key.JobSkillKey;
import vn.edu.iuh.fit.se.enums.SkillLevel;

@Entity
@Table(name = "job_skill")
@IdClass(JobSkillKey.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class JobSkill {
    @Column(name = "skill_level", nullable = false)
    private SkillLevel skillLevel;
    @Column(name = "more_info", length = 1000)
    private String moreInfo;

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "job_id")
    private Job job;
    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Override
    public String toString() {
        return "JobSkill{" +
                "skillLevel=" + skillLevel.getLevel() +
                ", moreInfo='" + moreInfo + '\'' +
                ", job=" + job.getId() +
                ", skill=" + skill.getId() +
                ", id=" + id +
                '}';
    }
}
