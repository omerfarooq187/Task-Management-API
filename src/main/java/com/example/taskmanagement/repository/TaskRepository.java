package com.example.taskmanagement.repository;

import com.example.taskmanagement.entity.task.Task;
import com.example.taskmanagement.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByUser(User user);
}
