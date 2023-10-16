package vn.edu.iuh.fit.se.service;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.entity.Address;
import vn.edu.iuh.fit.se.entity.CandidateSkill;

import java.util.List;
import java.util.Optional;

public interface CandidateSkillService {
    void insert(CandidateSkill item);
    void delete(Long value);
    Optional<CandidateSkill> findById(Long value);
    List<CandidateSkill> findAll();
}
