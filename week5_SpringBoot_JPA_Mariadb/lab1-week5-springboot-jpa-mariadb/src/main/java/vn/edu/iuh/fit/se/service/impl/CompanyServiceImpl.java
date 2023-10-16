package vn.edu.iuh.fit.se.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.entity.Company;
import vn.edu.iuh.fit.se.repositories.CompanyRepository;
import vn.edu.iuh.fit.se.service.CompanyService;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository repository;

    @Override
    public void insert(Company item) {
        repository.save(item);
    }

    @Override
    public void update(Company item) {
        repository.save(item);
    }

    @Override
    public void delete(Long value) {
        repository.deleteById(value);
    }

    @Override
    public Optional<Company> findById(Long value) {
        Optional<Company> result = repository.findById(value);
        return result.isPresent() ? Optional.of(result.get()) : Optional.empty();
    }

    @Override
    public List<Company> findAll() {
        return repository.findAll();
    }
}
