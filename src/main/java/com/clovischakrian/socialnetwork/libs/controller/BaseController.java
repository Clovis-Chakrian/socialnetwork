package com.clovischakrian.socialnetwork.libs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.ArrayList;

@ControllerAdvice
public class BaseController {
    protected <T> ResponseEntity<ApiResponse<T>> ApiReturn(T messageReturn) {
        return new ResponseEntity<>(new ApiResponse<>(true, messageReturn, new ArrayList<>()), HttpStatus.OK);
    }

    protected <T> ResponseEntity<ApiResponse<T>> ApiReturn(T messageReturn, HttpStatus statusCode) {
        return new ResponseEntity<>(new ApiResponse<>(true, messageReturn, new ArrayList<>()), statusCode);
    }
}