package com.example.taskmanagement.service.task;

import com.example.taskmanagement.dto.TaskDto;
import com.example.taskmanagement.entity.task.Task;
import com.example.taskmanagement.entity.user.User;
import com.example.taskmanagement.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepository repository;

    @Override
    public Task createTask(TaskDto taskDto, User user) {
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setDate(taskDto.getDate());
        task.setTaskStatus(taskDto.getTaskStatus());
        task.setUser(user);
        return repository.save(task);
    }

    @Override
    public List<Task> getTasks(User user) {
        return repository.findByUser(user);
    }


    @Override
    public Task getTaskById(int id, User user) {
        return repository.findById(id)
                .filter(task -> task.getUser().equals(user))
                .orElseThrow(()-> new RuntimeException("Task not found"));
    }

    @Override
    public Task updateTask(int id, TaskDto taskDto, User user) {
        Task task = getTaskById(id,user);
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setDate(taskDto.getDate());
        task.setTaskStatus(taskDto.getTaskStatus());
        return repository.save(task);
    }

    @Override
    public void deleteTask(int id, User user) {
        Task task = getTaskById(id, user);
        repository.delete(task);
    }

    @Override
    public TaskDto convertTaskToTaskDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getTaskStatus(),
                task.getDate()
        );
    }
}
