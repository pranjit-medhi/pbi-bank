package com.main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionControllerAdvoce {

    @ExceptionHandler
    public ResponseEntity<ErrorInfo> bankExceptionHandler(Exception exception)
    {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorMessage(exception.getMessage());
        errorInfo.setLocalDateTime(LocalDateTime.now());
        errorInfo.setErrorCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
    }
}
