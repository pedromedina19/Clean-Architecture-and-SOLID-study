package com.cleanArchitectureAndSolidstudy.api.infra.Exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}