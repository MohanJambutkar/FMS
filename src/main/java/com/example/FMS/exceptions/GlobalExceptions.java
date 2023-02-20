package com.example.FMS.exceptions;

import com.example.FMS.models.ResponseModel;
import javax.persistence.EntityNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.util.Collections;
import java.util.stream.Collectors;

public class GlobalExceptions extends ResponseEntityExceptionHandler {

    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        ResponseModel response=new ResponseModel();
        response.error = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        response.message = "Error processing request";
        response.responseCode = HttpStatus.BAD_REQUEST.value();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<ResponseModel> handleEntityNotFound(EntityNotFoundException ex){
        ResponseModel error = new ResponseModel();
        error.error = Collections.singletonList(ex.getMessage());
        error.responseCode = HttpStatus.NOT_FOUND.value();
        error.message = "Requested content not found";
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomExceptions.class)
    private ResponseEntity<ResponseModel> handleCustomException(CustomExceptions ex){
        ResponseModel error = new ResponseModel();
        error.error = Collections.singletonList(ex.getMessage());
        error.responseCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
        error.message = "There was error processing your request";
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
