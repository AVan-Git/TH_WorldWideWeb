package vn.edu.iuh.fit.se.service;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.entity.Address;
import vn.edu.iuh.fit.se.entity.Experience;

import java.util.List;
import java.util.Optional;

public interface ExperienceService {
    void insert(Experience item);
    void delete(Long value);
    Optional<Experience> findById(Long value);
    List<Experience> findAll();
}
