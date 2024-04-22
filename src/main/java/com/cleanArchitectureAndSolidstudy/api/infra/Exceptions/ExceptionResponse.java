package com.cleanArchitectureAndSolidstudy.api.infra.Exceptions;

import java.time.LocalDateTime;

public record ExceptionResponse(String message, LocalDateTime timestamp) {
    public ExceptionResponse(String message) {
        this(message, LocalDateTime.now());
    }
}
