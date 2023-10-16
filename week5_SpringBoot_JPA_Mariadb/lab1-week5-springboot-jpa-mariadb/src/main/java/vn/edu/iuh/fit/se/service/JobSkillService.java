package vn.edu.iuh.fit.se.service;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.entity.Address;
import vn.edu.iuh.fit.se.entity.JobSkill;

import java.util.List;
import java.util.Optional;

public interface JobSkillService {
    void insert(JobSkill item);
    void delete(Long value);
    Optional<JobSkill> findById(Long value);
    List<JobSkill> findAll();
}
