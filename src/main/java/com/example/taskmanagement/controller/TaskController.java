package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.TaskDto;
import com.example.taskmanagement.entity.task.Task;
import com.example.taskmanagement.entity.user.User;
import com.example.taskmanagement.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    @Autowired
    private final TaskService taskService;

    @PostMapping("/save-task")
    public ResponseEntity<Task> saveTask(
            @RequestBody TaskDto taskDto,
            @AuthenticationPrincipal User user
    ) {
        Task task = taskService.createTask(taskDto, user);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/get-tasks")
    public ResponseEntity<List<TaskDto>> getTasks(
            @AuthenticationPrincipal User user
    ) {
        List<TaskDto> tasks = taskService.getTasks(user)
                .stream()
                .map(taskService::convertTaskToTaskDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/find-task/{id}")
    public ResponseEntity<TaskDto> findTask(
            @PathVariable int id,
            @AuthenticationPrincipal User user
    ) {
        Task task = taskService.getTaskById(id,user);
        TaskDto taskDto = taskService.convertTaskToTaskDto(task);
        return ResponseEntity.ok(taskDto);
    }

    @PostMapping("/update-task")
    public ResponseEntity<Task> updateTask(
            @RequestBody TaskDto taskDto,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(taskService.updateTask(taskDto.getId(), taskDto,user));
    }

    @PostMapping("delete-task/{id}")
    public ResponseEntity<String> deleteTask(
            @PathVariable int id,
            @AuthenticationPrincipal User user
    ) {
        taskService.deleteTask(id, user);
        return ResponseEntity.ok("Task deleted Successfully");
    }
}
