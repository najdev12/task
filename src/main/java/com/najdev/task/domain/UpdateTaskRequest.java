package com.najdev.task.domain;

import com.najdev.task.domain.entity.TaskPriority;
import com.najdev.task.domain.entity.TaskStatus;

import java.time.LocalDate;

public class UpdateTaskRequest {
    private String title;
    private String description;
    LocalDate dueDate;
    TaskStatus status;
    TaskPriority priority;
}
