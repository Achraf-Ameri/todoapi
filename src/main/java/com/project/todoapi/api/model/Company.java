package com.project.todoapi.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Company {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int companyId;
    private String companyName;

    public Company() {}

    public Company(int id, String name){
        this.companyId = id;
        this.companyName = name;
    }

    public int getCompanyId(){
        return this.companyId;
    }

    public void setCompanyId(int id){
        this.companyId = id;
    }

    public String getCompanyName(){
        return this.companyName;
    }

    public void setCompanyName(String name){
        this.companyName = name;
    }
}
