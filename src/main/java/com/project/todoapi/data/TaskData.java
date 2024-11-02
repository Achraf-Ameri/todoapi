package com.project.todoapi.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.todoapi.api.model.Task;

public interface TaskData extends JpaRepository<Task, Integer> {
    List<Task> findByUserId(Integer userId);
}
