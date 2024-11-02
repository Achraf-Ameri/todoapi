package com.project.todoapi.api.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class AppUser {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    private UserRole userRole;
    private int belongedCompanyId;
    
    public AppUser() {}

    public AppUser(int id, String name, UserRole role, int companyId) {
        this.userId = id;
        this.userName = name;
        this.userRole = role;
        this.belongedCompanyId = companyId;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public UserRole getUserRole() {
        return this.userRole;
    }

    public void setUserRole(UserRole role) {
        this.userRole = role;
    }

    public int getBelongedCompanyId() {
        return this.belongedCompanyId;
    }

    public void setBelongedCompany(int company) {
        this.belongedCompanyId = company;
    }
}
