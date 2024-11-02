package com.project.todoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.todoapi.api.model.AppUser;
import com.project.todoapi.api.model.Task;
import com.project.todoapi.data.TaskData;

@Service
public class TaskService {

    @Autowired
    private TaskData taskdata;

    public List<Task> getAllTasks() {
        return taskdata.findAll();
    }

    public Optional<Task> getTaskById(Integer id) {
        return taskdata.findById(id);
    }

    public List<Task> getTasksByUserRole(AppUser user) {
        switch (user.getUserRole()) {
            case STANDARD:
                return taskdata.findByUser(user);
            case COMPANY_ADMIN:
                return taskdata.findByUser_BelongedCompanyId(user.getBelongedCompanyId());
            case SUPER_USER:
                return taskdata.findAll();
            default:
                throw new IllegalStateException("Unknown User Role : " + user.getUserRole());
        }
    }

    public Task createTask(Task task) {
        return taskdata.save(task);
    }

    public void deleteTask(Integer id) {
        taskdata.deleteById(id);
    }
}