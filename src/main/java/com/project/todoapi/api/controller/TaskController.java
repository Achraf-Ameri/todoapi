package com.project.todoapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.todoapi.api.model.AppUser;
import com.project.todoapi.api.model.Task;
import com.project.todoapi.service.TaskService;
import com.project.todoapi.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Integer id) {
        return ResponseEntity.of(taskService.getTaskById(id));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks(@RequestParam int userId) {
        Optional<AppUser> optionalUser = userService.getUserById(userId);
        
        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        AppUser user = optionalUser.get();

        List<Task> tasks = taskService.getTasksByUserRole(user);
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
    }
}
