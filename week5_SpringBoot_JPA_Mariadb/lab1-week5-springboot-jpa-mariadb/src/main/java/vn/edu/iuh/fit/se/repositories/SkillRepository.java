package vn.edu.iuh.fit.se.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.se.entity.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
}
