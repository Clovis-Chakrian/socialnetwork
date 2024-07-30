package com.clovischakrian.socialnetwork.api;

import com.clovischakrian.socialnetwork.libs.controller.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse> illegalArgumentExceptionHandler(IllegalArgumentException ex) {
        List<String> errors = new ArrayList<>();
        errors.add(ex.getMessage());

        return new ResponseEntity<>(new ApiResponse(false, null, errors), HttpStatus.BAD_REQUEST);
    }
}
