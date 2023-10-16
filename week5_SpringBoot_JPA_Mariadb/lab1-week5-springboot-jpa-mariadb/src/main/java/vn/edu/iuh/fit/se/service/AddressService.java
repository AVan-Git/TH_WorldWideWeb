package vn.edu.iuh.fit.se.service;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.entity.Address;
import vn.edu.iuh.fit.se.entity.Company;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    void insert(Address item);
    void delete(Long value);
    Optional<Address> findById(Long value);
    List<Address> findAll();
}
