package com.najdev.task.service;

import com.najdev.task.domain.CreateTaskRequest;
import com.najdev.task.domain.entity.Task;

public interface TaskService  {

    Task createTask(CreateTaskRequest request );
}
