package com.example.demo.messaging;

import org.javatuples.Pair;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public class ApiError {


        private HttpStatus status;
        private String message;
        private List<Pair> errors;

        public ApiError(HttpStatus status, String message, List<Pair> errors) {
            super();
            this.status = status;
            this.message = message;
            this.errors = errors;
        }

        public ApiError(HttpStatus status, String message, Pair error) {
            super();
            this.status = status;
            this.message = message;
            errors = Arrays.asList(error);
        }


}
