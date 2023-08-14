package com.banhodepote.exception;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({ ApiException.class })
    protected ResponseEntity<ApiErrorResponse> handleApiException(ApiException ex) {
        return new ResponseEntity<>(new ApiErrorResponse(ex.getStatus(), ex.getMessage(), Instant.now()), ex.getStatus());
    }
}