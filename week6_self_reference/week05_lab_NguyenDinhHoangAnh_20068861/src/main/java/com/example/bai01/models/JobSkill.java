package com.example.bai01.models;

import com.example.bai01.enums.SkillLevel;
import com.example.bai01.ids.JobId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "job_skill")
@IdClass(JobId.class)
public class JobSkill {
    @Column(name = "more_infos", columnDefinition = "varchar(1000)")
    private String moreInfo;
    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "job_id")
    private Job job;
    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_id")
    private Skill skill;
    @Enumerated(EnumType.STRING)
    private SkillLevel skillLevel;
}
