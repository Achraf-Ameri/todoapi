package com.project.todoapi.data;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.todoapi.api.model.AppUser;

public interface UserData extends JpaRepository<AppUser, Integer> {}