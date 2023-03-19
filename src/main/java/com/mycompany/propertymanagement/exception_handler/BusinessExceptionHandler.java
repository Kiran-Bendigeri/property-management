package com.mycompany.propertymanagement.exception_handler;

import com.mycompany.propertymanagement.exception.BusinessException;
import com.mycompany.propertymanagement.exception.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class BusinessExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> businessExceptionHandler(BusinessException businessException){
        System.out.println("BusinessException is thrown");
        return new ResponseEntity<List<ErrorModel>>(businessException.getErrors(), HttpStatus.NOT_FOUND);
    }
}
