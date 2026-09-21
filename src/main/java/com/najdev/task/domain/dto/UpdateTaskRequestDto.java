package com.najdev.task.domain.dto;

import com.najdev.task.domain.entity.TaskPriority;
import com.najdev.task.domain.entity.TaskStatus;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record UpdateTaskRequestDto(

        @NotBlank(message = ERROR_MESSAGE_LENGTH)
        @Length(max = 255, message = ERROR_MESSAGE_LENGTH)
        String title,

        @Nullable
        @Length(max = 1000, message = ERROR_MESSAGE_DESCRIPTION_LENGTH)
        String description,

        @Nullable
        @FutureOrPresent(message = ERROR_MESSAGE_DUE_DATE)
        LocalDate dueDate,
        @NotNull(message = ERROR_MESSAGE_PRIORITY)
        TaskPriority priority,

        @NotNull(message = ERROR_MESSAGE_STATUS)
        TaskStatus status
) {
    private static final String ERROR_MESSAGE_LENGTH =
            "Title must be between 1 and 255 characters";
    private static final String ERROR_MESSAGE_DESCRIPTION_LENGTH =
            "Description must be max 1000 characters";
    private static final String ERROR_MESSAGE_DUE_DATE =
            "Due date must be in the future or present";
    private static final String ERROR_MESSAGE_PRIORITY =
            "Priority must be provided";
    private static final String ERROR_MESSAGE_STATUS =
            "Status must be provided";
}
