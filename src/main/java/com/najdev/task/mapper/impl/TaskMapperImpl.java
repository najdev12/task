package com.najdev.task.mapper.impl;

import com.najdev.task.domain.CreateTaskRequest;
import com.najdev.task.domain.UpdateTaskRequest;
import com.najdev.task.domain.dto.CreateTaskRequestDto;
import com.najdev.task.domain.dto.TaskDto;
import com.najdev.task.domain.dto.UpdateTaskRequestDto;
import com.najdev.task.domain.entity.Task;
import com.najdev.task.mapper.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public CreateTaskRequest toCreateTaskRequest(CreateTaskRequestDto createTaskRequestDto) {
        return new CreateTaskRequest(
                createTaskRequestDto.title(),
                createTaskRequestDto.description(),
                createTaskRequestDto.dueDate(),
                createTaskRequestDto.priority()
        );
    }

    @Override
    public TaskDto toTaskDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority(),
                task.getStatus()
        );
    }

    @Override
    public UpdateTaskRequest toUpdateTaskRequest(UpdateTaskRequestDto updateTaskRequestDto) {
        return new UpdateTaskRequest(
                updateTaskRequestDto.title(),
                updateTaskRequestDto.description(),
                updateTaskRequestDto.dueDate(),
                updateTaskRequestDto.status(),
                updateTaskRequestDto.priority()
        );
    }
}
