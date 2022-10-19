package com.nttdata.bootcamp.project.CustomerProduct.utils.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}