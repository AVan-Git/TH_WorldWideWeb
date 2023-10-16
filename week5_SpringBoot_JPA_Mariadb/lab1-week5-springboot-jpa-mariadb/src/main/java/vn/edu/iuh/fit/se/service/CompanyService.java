package vn.edu.iuh.fit.se.service;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    void insert(Company item);
    void update(Company item);
    void delete(Long value);
    Optional<Company> findById(Long value);
    List<Company> findAll();
}
