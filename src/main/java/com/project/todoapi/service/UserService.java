package com.project.todoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.todoapi.api.model.AppUser;
import com.project.todoapi.data.UserData;

@Service
public class UserService {

    @Autowired
    private UserData userData;

    public List<AppUser> getAllUsers() {
        return userData.findAll();
    }

    public Optional<AppUser> getUserById(Integer id) {
        return userData.findById(id);
    }

    public AppUser createUser(AppUser user) {
        return userData.save(user);
    }

    public void deleteUser(Integer id) {
        userData.deleteById(id);
    }
}