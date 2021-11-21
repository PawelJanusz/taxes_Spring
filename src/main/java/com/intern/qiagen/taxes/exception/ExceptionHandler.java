package com.intern.qiagen.taxes.exception;

import com.intern.qiagen.taxes.model.Revenue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<Object> exception(IllegalArgumentException exception){
        return new ResponseEntity<>("Wrong gross revenue. Revenue should be greater than 10 tys.", HttpStatus.BAD_REQUEST);
    }
}
