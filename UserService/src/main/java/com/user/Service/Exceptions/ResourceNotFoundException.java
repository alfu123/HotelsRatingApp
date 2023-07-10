package com.user.Service.Exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("userId not found on server");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
