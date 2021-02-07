package com.company.backend.exeption;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorResponseHandler {

    private final String error;
    private final LocalDateTime timestamp;

    public ErrorResponseHandler(String error) {
        this.error = error;
        this.timestamp = LocalDateTime.now();
    }

}
