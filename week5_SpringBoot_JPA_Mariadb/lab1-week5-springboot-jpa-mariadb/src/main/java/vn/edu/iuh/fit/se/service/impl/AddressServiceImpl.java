package vn.edu.iuh.fit.se.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.entity.Address;
import vn.edu.iuh.fit.se.entity.Company;
import vn.edu.iuh.fit.se.repositories.AddressRepository;
import vn.edu.iuh.fit.se.repositories.CompanyRepository;
import vn.edu.iuh.fit.se.service.AddressService;
import vn.edu.iuh.fit.se.service.CompanyService;

import java.util.List;
import java.util.Optional;
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository repository;

    @Override
    public void insert(Address item) {
        repository.save(item);
    }

    @Override
    public void delete(Long value) {
        repository.deleteById(value);
    }

    @Override
    public Optional<Address> findById(Long value) {
        Optional<Address> result = repository.findById(value);
        return result.isPresent() ? Optional.of(result.get()) : Optional.empty();
    }

    @Override
    public List<Address> findAll() {
        return repository.findAll();
    }
}
