package com.najdev.task.exception;

import java.util.UUID;

public class TaskNotFoundException extends RuntimeException {

    private final  UUID taskId;

    public TaskNotFoundException(UUID taskId) {

        super(String.format("Task with id %s not found", taskId));

        this.taskId = taskId;
    }

    public UUID getTaskId() {
        return taskId;
    }
}
