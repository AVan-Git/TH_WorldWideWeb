package vn.edu.iuh.fit.se.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.entity.Candidate;
import vn.edu.iuh.fit.se.repositories.CandidateRepository;
import vn.edu.iuh.fit.se.service.CandidateService;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository repository;

    @Override
    public void insert(Candidate item) {
        repository.save(item);
    }

    @Override
    public void delete(Long value) {
        repository.deleteById(value);
    }

    @Override
    public Optional<Candidate> findById(Long value) {
        Optional<Candidate> result = repository.findById(value);
        return result.isPresent() ? Optional.of(result.get()) : Optional.empty();
    }

    @Override
    public List<Candidate> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Candidate> findBaginated(Pageable pageable) {
        return repository.findAll(pageable);
    }

//    @Override
//    public List<Candidate> findAllByPhoneIsLikeIgnoreCase(String phone, Pageable pageable) {
//        return repository.findAllByPhoneIsLikeIgnoreCase(phone,pageable);
//    }
}
