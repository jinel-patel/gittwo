package com.example.hibernatecrud.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
@RestControllerAdvice
public class EmployeeNotFoundException extends RuntimeException
{
    public EmployeeNotFoundException()
    {
        super();
    }

    public EmployeeNotFoundException(String message)
    {
        super(message);
    }


    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ApllicationError> handleEmployeeNotFoundException(EmployeeNotFoundException exception, WebRequest webRequest) {
        ApllicationError error = new ApllicationError();
        error.setCode(102);
        error.setMessage(exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
