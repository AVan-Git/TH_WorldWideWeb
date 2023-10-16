package vn.edu.iuh.fit.se.entity.key;

import jakarta.persistence.Embeddable;
import vn.edu.iuh.fit.se.entity.Candidate;
import vn.edu.iuh.fit.se.entity.Skill;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CandidateSkillKey implements Serializable {
    private Candidate candidate;
    private Skill skill;
    private long id;

    public CandidateSkillKey() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandidateSkillKey that = (CandidateSkillKey) o;
        return id == that.id && Objects.equals(candidate, that.candidate) && Objects.equals(skill, that.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidate, skill, id);
    }
}
