package com.example.demo.controllers;


import com.example.demo.messaging.ApiError;
import org.javatuples.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.concurrent.ExecutionException;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

        @ExceptionHandler(ExecutionException.class)
        protected ResponseEntity<Object> handleException(ExecutionException ex, WebRequest request){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ApiError(
                            HttpStatus.INTERNAL_SERVER_ERROR,
                            ex.getMessage(),
                            new Pair<>("swr", "something went wrong")
                            )
            );
        }

}
