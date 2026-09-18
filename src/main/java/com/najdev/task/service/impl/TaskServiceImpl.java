package com.najdev.task.service.impl;

import com.najdev.task.domain.CreateTaskRequest;
import com.najdev.task.domain.entity.Task;
import com.najdev.task.domain.entity.TaskStatus;
import com.najdev.task.repository.TaskRepository;
import com.najdev.task.service.TaskService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(CreateTaskRequest request) {
        Instant now = Instant.now();
        Task task = new Task(
                null,
                request.title(),
                request.description(),
                request.dueDate(),
                TaskStatus.OPEN,
                request.priority(),
                now,
                now);
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll(Sort.by(Sort.Direction.ASC, "created"));
    }
}
