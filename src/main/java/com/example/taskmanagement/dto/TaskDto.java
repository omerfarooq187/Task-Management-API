package com.example.taskmanagement.dto;

import com.example.taskmanagement.entity.task.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private int id;
    private String title;
    private String description;
    private TaskStatus taskStatus;
    private LocalDate date;
}
