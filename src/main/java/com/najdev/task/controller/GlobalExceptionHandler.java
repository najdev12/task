package com.najdev.task.controller;

import com.najdev.task.domain.dto.ErrorDto;
import com.najdev.task.exception.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.UUID;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorDto>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {

        List<ErrorDto> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new ErrorDto(error.getField(), error.getDefaultMessage()))
                .toList();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }

    @ExceptionHandler(TaskNotFoundException.class )
    public ResponseEntity<ErrorDto> handleTaskNotFoundExceptions (TaskNotFoundException ex) {
        UUID taskNotFoundId = ex.getTaskId();
        String errorMessage = String.format("Task with ID '%s' not found", taskNotFoundId);
        ErrorDto errorDto = new ErrorDto(null, errorMessage);
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }
}
