package vn.edu.iuh.fit.se.service;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.entity.Skill;

import java.util.List;
import java.util.Optional;

public interface SkillService {
    void insert(Skill item);
    void delete(Long value);
    Optional<Skill> findById(Long value);
    List<Skill> findAll();
}
