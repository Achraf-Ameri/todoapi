package com.project.todoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.todoapi.api.model.AppUser;
import com.project.todoapi.api.model.Task;
import com.project.todoapi.data.TaskData;
import com.project.todoapi.data.UserData;

@Service
public class TaskService {

    @Autowired
    private TaskData taskData;

    @Autowired
    private UserData userData;

    public List<Task> getAllTasks() {
        return taskData.findAll();
    }

    public Optional<Task> getTaskById(Integer id) {
        return taskData.findById(id);
    }

    public List<Task> getTasksByUserRole(AppUser user) {
        switch (user.getUserRole()) {
            case STANDARD:
                return taskData.findByUser(user);
            case COMPANY_ADMIN:
                return taskData.findByUser_BelongedCompanyId(user.getBelongedCompanyId());
            case SUPER_USER:
                return taskData.findAll();
            default:
                throw new IllegalStateException("Unknown User Role : " + user.getUserRole());
        }
    }

    public Task createTask(Task task, Integer userId) {
        AppUser user = userData.findById(userId).orElse(null);
        
        if (user == null) {
            throw new RuntimeException("User not found with id: " + userId);
        }

        task.setUser(user);
        
        return taskData.save(task);
    }

    public void deleteTask(Integer id) {
        taskData.deleteById(id);
    }
}