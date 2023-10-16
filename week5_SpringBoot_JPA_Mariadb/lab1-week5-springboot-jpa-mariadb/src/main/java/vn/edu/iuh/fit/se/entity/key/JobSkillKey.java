package vn.edu.iuh.fit.se.entity.key;

import jakarta.persistence.Embeddable;
import vn.edu.iuh.fit.se.entity.Job;
import vn.edu.iuh.fit.se.entity.Skill;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class JobSkillKey implements Serializable {
    private Job job;
    private Skill skill;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobSkillKey that = (JobSkillKey) o;
        return Objects.equals(job, that.job) && Objects.equals(skill, that.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, skill);
    }

    public JobSkillKey() {
    }
}
