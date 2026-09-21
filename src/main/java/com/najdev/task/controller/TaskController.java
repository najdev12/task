package com.najdev.task.controller;

import com.najdev.task.domain.CreateTaskRequest;
import com.najdev.task.domain.UpdateTaskRequest;
import com.najdev.task.domain.dto.CreateTaskRequestDto;
import com.najdev.task.domain.dto.TaskDto;
import com.najdev.task.domain.dto.UpdateTaskRequestDto;
import com.najdev.task.domain.entity.Task;
import com.najdev.task.mapper.TaskMapper;
import com.najdev.task.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping
    public ResponseEntity<List<TaskDto>> getTasks() {
        List<TaskDto> listTasksDto = taskService.getTasks().stream()
                .map(taskMapper::toTaskDto)
                .toList();

        return ResponseEntity.ok(listTasksDto);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable UUID taskId,
                                              @Valid @RequestBody UpdateTaskRequestDto updateTaskRequestDto)
    {
        UpdateTaskRequest updateTaskRequest = taskMapper.toUpdateTaskRequest(updateTaskRequestDto);
        Task task = taskService.updateTask(taskId, updateTaskRequest);
        TaskDto taskDto = taskMapper.toTaskDto(task);

        return ResponseEntity.ok(taskDto);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }
}
