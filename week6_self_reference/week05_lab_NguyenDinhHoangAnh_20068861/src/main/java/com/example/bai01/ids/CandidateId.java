package com.example.bai01.ids;

import com.example.bai01.models.Candidate;
import com.example.bai01.models.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateId implements Serializable {
    private Candidate candidate;
    private Skill skill;
}
