package com.project.todoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.todoapi.api.model.Company;
import com.project.todoapi.data.CompanyData;

@Service
public class CompanyService {

    @Autowired
    private CompanyData companyData;

    public List<Company> getAllCompanies() {
        return companyData.findAll();
    }

    public Optional<Company> getCompanyById(Integer id) {
        return companyData.findById(id);
    }

    public Company createCompany(Company company) {
        return companyData.save(company);
    }

    public void deleteCompany(Integer id) {
        companyData.deleteById(id);
    }
}