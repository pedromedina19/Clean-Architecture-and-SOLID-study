package com.cleanArchitectureAndSolidstudy.api.infra.dtos;

import java.time.LocalDateTime;

public record ExceptionResponseDto(String message, LocalDateTime timestamp) {
    public ExceptionResponseDto(String message) {
        this(message, LocalDateTime.now());
    }
}