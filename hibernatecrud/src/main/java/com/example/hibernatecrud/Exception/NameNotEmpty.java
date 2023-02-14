package com.example.hibernatecrud.Exception;

import ch.qos.logback.core.spi.ErrorCodes;
import org.hibernate.id.enhanced.StandardOptimizerDescriptor;
import org.slf4j.event.Level;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class NameNotEmpty extends RuntimeException
{
    public NameNotEmpty()
    {
        super();
    }
    public NameNotEmpty(String message )
    {
        super(message);

    }

    @ExceptionHandler(NameNotEmpty.class)
    public ResponseEntity<ApllicationError> handleCustomerNotFoundException(NameNotEmpty exception, WebRequest webRequest) {
        ApllicationError error = new ApllicationError();
        error.setCode(101);
        error.setMessage(exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }



}



