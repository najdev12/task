package com.najdev.task.service;

import com.najdev.task.domain.CreateTaskRequest;
import com.najdev.task.domain.UpdateTaskRequest;
import com.najdev.task.domain.entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService  {

    Task createTask(CreateTaskRequest request );
    List<Task> getTasks();
    Task updateTask(UUID taskId, UpdateTaskRequest request);
    void deleteTask(UUID taskId);
}
