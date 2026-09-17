package com.najdev.task.domain.dto;

public record ErrorDto(
        String field,
        String message
)  {
}
