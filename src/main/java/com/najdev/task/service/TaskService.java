package com.najdev.task.service;

import com.najdev.task.domain.CreateTaskRequest;
import com.najdev.task.domain.entity.Task;

import java.util.List;

public interface TaskService  {

    Task createTask(CreateTaskRequest request );
    List<Task> getTasks();
}
