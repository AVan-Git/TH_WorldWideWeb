package com.example.bai01.models;

import com.example.bai01.enums.SkillLevel;
import com.example.bai01.ids.CandidateId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "candidate_skill")
@IdClass(CandidateId.class)
public class CandidateSkill {
    private SkillLevel skillLevel;
    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_id")
    private Skill skill;
    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "can_id")
    private Candidate candidate;
    @Column(name = "more_infos", columnDefinition = "varchar(1000)")
    private String moreInfo;
}
