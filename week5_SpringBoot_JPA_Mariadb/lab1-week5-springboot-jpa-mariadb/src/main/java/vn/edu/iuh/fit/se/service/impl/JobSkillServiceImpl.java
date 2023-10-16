package vn.edu.iuh.fit.se.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.entity.Address;
import vn.edu.iuh.fit.se.entity.JobSkill;
import vn.edu.iuh.fit.se.repositories.AddressRepository;
import vn.edu.iuh.fit.se.repositories.JobSkillRepository;
import vn.edu.iuh.fit.se.service.AddressService;
import vn.edu.iuh.fit.se.service.JobSkillService;

import java.util.List;
import java.util.Optional;

@Service
public class JobSkillServiceImpl implements JobSkillService {

    @Autowired
    private JobSkillRepository repository;

    @Override
    public void insert(JobSkill item) {
        repository.save(item);
    }

    @Override
    public void delete(Long value) {
        repository.deleteById(value);
    }

    @Override
    public Optional<JobSkill> findById(Long value) {
        Optional<JobSkill> result = repository.findById(value);
        return result.isPresent() ? Optional.of(result.get()) : Optional.empty();
    }

    @Override
    public List<JobSkill> findAll() {
        return repository.findAll();
    }
}
