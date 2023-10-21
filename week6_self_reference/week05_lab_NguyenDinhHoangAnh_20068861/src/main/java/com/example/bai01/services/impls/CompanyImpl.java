package com.example.bai01.services.impls;

import com.example.bai01.models.Company;
import com.example.bai01.repositories.CompanyRepository;
import com.example.bai01.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;


    @Override
    public Company findById(long id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        Company company = optionalCompany.orElseGet(optionalCompany::orElseThrow);
        return company;
    }
}
