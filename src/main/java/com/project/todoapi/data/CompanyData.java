package com.project.todoapi.data;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.todoapi.api.model.Company;

public interface CompanyData extends JpaRepository<Company, Integer> {}