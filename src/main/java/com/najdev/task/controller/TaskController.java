package com.najdev.task.controller;

import com.najdev.task.domain.CreateTaskRequest;
import com.najdev.task.domain.dto.CreateTaskRequestDto;
import com.najdev.task.domain.dto.TaskDto;
import com.najdev.task.domain.entity.Task;
import com.najdev.task.mapper.TaskMapper;
import com.najdev.task.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@Valid @RequestBody CreateTaskRequestDto createTaskRequestDto) {

        CreateTaskRequest createTaskRequest = taskMapper.toCreateTaskRequest(createTaskRequestDto);
        Task task = taskService.createTask(createTaskRequest);
        TaskDto taskDto = taskMapper.toTaskDto(task);

        return ResponseEntity.status(HttpStatus.CREATED).body(taskDto);

    }
}
