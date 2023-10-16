package vn.edu.iuh.fit.se.service;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.entity.Address;
import vn.edu.iuh.fit.se.entity.Candidate;

import java.util.List;
import java.util.Optional;

public interface CandidateService {
    void insert(Candidate item);
    void delete(Long value);
    Optional<Candidate> findById(Long value);
    List<Candidate> findAll();
}
