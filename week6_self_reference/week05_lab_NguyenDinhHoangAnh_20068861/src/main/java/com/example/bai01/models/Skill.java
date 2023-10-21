package com.example.bai01.models;

import com.example.bai01.enums.SkillType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "skill")
public class Skill {
    @Enumerated(EnumType.STRING)
    private SkillType skillType;
    @Column(name = "skill_name", columnDefinition = "varchar(150)")
    private String skillName;
    @Column(name = "skill_desc", columnDefinition = "varchar(300)")
    private String skillDescription;
    @Id
    @Column(name = "skill_id", columnDefinition = "bigint(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(mappedBy = "skill", fetch = FetchType.LAZY)
    private List<JobSkill> jobSkills;
}
