package com.lcwd.rating.RatingService.Exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String s) {
        super(s);
    }
    public ResourceNotFoundException() {
        super("Invalid Entry");
    }
}
