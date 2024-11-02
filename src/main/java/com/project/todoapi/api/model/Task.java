package com.project.todoapi.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;
    private String taskTitle;
    private String taskDescription;
    private TaskStatus taskStatus;
    private int userId;

    public Task() {}

    public Task(int id, String title, String description, TaskStatus status){
        this.taskId = id;
        this.taskTitle = title;
        this.taskDescription = description;
        this.taskStatus = status;
    }

    public int getTaskId() {
        return this.taskId;
    }

    public void setTaskId(int id) {
        this.taskId = id;
    }

    public String getTaskTitle() {
        return this.taskTitle;
    }

    public void setTaskTitle(String title) {
        this.taskTitle = title;
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }

    public void setTaskDescription(String description) {
        this.taskDescription = description;
    }

    public TaskStatus getTaskStatus() {
        return this.taskStatus;
    }
    
    public void setTaskStatus(TaskStatus status) {
        this.taskStatus = status;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int id) {
        this.userId = id;
    }
}
