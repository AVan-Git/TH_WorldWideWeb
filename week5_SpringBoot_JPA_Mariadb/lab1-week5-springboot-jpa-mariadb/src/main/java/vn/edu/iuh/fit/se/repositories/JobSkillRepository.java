package vn.edu.iuh.fit.se.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.se.entity.JobSkill;

@Repository
public interface JobSkillRepository extends JpaRepository<JobSkill, Long> {
}
