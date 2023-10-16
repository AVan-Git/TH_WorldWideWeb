package vn.edu.iuh.fit.se.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.entity.Address;
import vn.edu.iuh.fit.se.entity.CandidateSkill;
import vn.edu.iuh.fit.se.repositories.AddressRepository;
import vn.edu.iuh.fit.se.repositories.CandidateSkillRepository;
import vn.edu.iuh.fit.se.service.AddressService;
import vn.edu.iuh.fit.se.service.CandidateSkillService;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateSkillServiceImpl implements CandidateSkillService {

    @Autowired
    private CandidateSkillRepository repository;

    @Override
    public void insert(CandidateSkill item) {
        repository.save(item);
    }

    @Override
    public void delete(Long value) {
        repository.deleteById(value);
    }

    @Override
    public Optional<CandidateSkill> findById(Long value) {
        Optional<CandidateSkill> result = repository.findById(value);
        return result.isPresent() ? Optional.of(result.get()) : Optional.empty();
    }

    @Override
    public List<CandidateSkill> findAll() {
        return repository.findAll();
    }
}
