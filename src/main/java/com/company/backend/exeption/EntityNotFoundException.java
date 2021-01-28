package com.company.backend.exeption;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Long id) {
        super(String.format("Entity with ID: %d was not found!", id));
    }

}
