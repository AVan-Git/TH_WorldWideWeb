package vn.edu.iuh.fit.se.entity.key;

import vn.edu.iuh.fit.se.entity.Candidate;
import vn.edu.iuh.fit.se.entity.Skill;

import java.io.Serializable;


public class CandidateSkillKey implements Serializable {
    private Candidate candidate;
    private Skill skill;
}
