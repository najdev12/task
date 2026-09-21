package com.najdev.task.service.impl;

import com.najdev.task.domain.CreateTaskRequest;
import com.najdev.task.domain.UpdateTaskRequest;
import com.najdev.task.domain.entity.Task;
import com.najdev.task.domain.entity.TaskStatus;
import com.najdev.task.exception.TaskNotFoundException;
import com.najdev.task.repository.TaskRepository;
import com.najdev.task.service.TaskService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

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

    @Override
    public Task updateTask(UUID taskId, UpdateTaskRequest request) {
        Task task = taskRepository.findById(taskId).orElseThrow(
                () -> new TaskNotFoundException(taskId)
        );
        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setDueDate(request.dueDate());
        task.setPriority(request.priority());
        task.setUpdated(Instant.now());
        return taskRepository.save(task);
    }
}
