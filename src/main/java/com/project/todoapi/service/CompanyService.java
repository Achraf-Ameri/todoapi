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
    private CompanyData companydata;

    public List<Company> getAllCompanies() {
        return companydata.findAll();
    }

    public Optional<Company> getCompanyById(Integer id) {
        return companydata.findById(id);
    }

    public Company createCompany(Company company) {
        return companydata.save(company);
    }

    public void deleteCompany(Integer id) {
        companydata.deleteById(id);
    }
}