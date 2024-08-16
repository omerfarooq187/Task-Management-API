package com.example.taskmanagement.service.task;

import com.example.taskmanagement.dto.TaskDto;
import com.example.taskmanagement.entity.task.Task;
import com.example.taskmanagement.entity.user.User;

import java.util.List;

public interface TaskService {
    Task createTask(TaskDto taskDto, User user);
    List<Task> getTasks(User user);
    Task getTaskById(int id, User user);
    Task updateTask(int id, TaskDto taskDto, User user);
    void deleteTask(int id, User user);

    TaskDto convertTaskToTaskDto(Task task);
}
