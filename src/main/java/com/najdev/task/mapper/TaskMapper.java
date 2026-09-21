package com.najdev.task.mapper;

import com.najdev.task.domain.CreateTaskRequest;
import com.najdev.task.domain.UpdateTaskRequest;
import com.najdev.task.domain.dto.CreateTaskRequestDto;
import com.najdev.task.domain.dto.TaskDto;
import com.najdev.task.domain.dto.UpdateTaskRequestDto;
import com.najdev.task.domain.entity.Task;

public interface TaskMapper {

    CreateTaskRequest toCreateTaskRequest(CreateTaskRequestDto createTaskRequestDto);
    TaskDto toTaskDto(Task task);
    UpdateTaskRequest toUpdateTaskRequest(UpdateTaskRequestDto updateTaskRequestDto);
}
