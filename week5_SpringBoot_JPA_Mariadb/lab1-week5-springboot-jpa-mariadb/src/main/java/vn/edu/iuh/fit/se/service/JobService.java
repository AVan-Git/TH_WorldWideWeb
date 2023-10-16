package vn.edu.iuh.fit.se.service;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.entity.Address;
import vn.edu.iuh.fit.se.entity.Job;

import java.util.List;
import java.util.Optional;

public interface JobService {
    void insert(Job item);
    void delete(Long value);
    Optional<Job> findById(Long value);
    List<Job> findAll();
}
