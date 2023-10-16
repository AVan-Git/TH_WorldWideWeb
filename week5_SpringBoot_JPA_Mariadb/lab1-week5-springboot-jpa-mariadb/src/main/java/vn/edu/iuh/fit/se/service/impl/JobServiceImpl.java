package vn.edu.iuh.fit.se.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.entity.Address;
import vn.edu.iuh.fit.se.entity.Job;
import vn.edu.iuh.fit.se.repositories.AddressRepository;
import vn.edu.iuh.fit.se.repositories.JobRepository;
import vn.edu.iuh.fit.se.service.AddressService;
import vn.edu.iuh.fit.se.service.JobService;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository repository;

    @Override
    public void insert(Job item) {
        repository.save(item);
    }

    @Override
    public void delete(Long value) {
        repository.deleteById(value);
    }

    @Override
    public Optional<Job> findById(Long value) {
        Optional<Job> result = repository.findById(value);
        return result.isPresent() ? Optional.of(result.get()) : Optional.empty();
    }

    @Override
    public List<Job> findAll() {
        return repository.findAll();
    }
}
