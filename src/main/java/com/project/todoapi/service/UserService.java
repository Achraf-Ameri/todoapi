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
    private UserData userdata;

    public List<AppUser> getAllUsers() {
        return userdata.findAll();
    }

    public Optional<AppUser> getUserById(Integer id) {
        return userdata.findById(id);
    }

    public AppUser createUser(AppUser user) {
        return userdata.save(user);
    }

    public void deleteUser(Integer id) {
        userdata.deleteById(id);
    }
}