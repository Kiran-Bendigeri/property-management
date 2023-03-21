package com.mycompany.propertymanagement.exception_handler;

import com.mycompany.propertymanagement.exception.BusinessException;
import com.mycompany.propertymanagement.exception.ErrorModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedList;
import java.util.List;

@ControllerAdvice
public class BusinessExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> fieldValidationHandler(MethodArgumentNotValidException manv){
        List<ErrorModel> errorModelList = new LinkedList<>();
        ErrorModel errorModel = null;
        List<FieldError> fieldError = manv.getBindingResult().getFieldErrors();

        for (FieldError fieldError1:fieldError) {
            logger.debug("Inside field validation: {} - {}", fieldError1.getCode(), fieldError1.getDefaultMessage());
            logger.info("Inside field validation: {} - {}", fieldError1.getCode(), fieldError1.getDefaultMessage());
            logger.warn("Inside field validation: {} - {}", fieldError1.getCode(), fieldError1.getDefaultMessage());
            logger.error("Inside field validation: {} - {}", fieldError1.getCode(), fieldError1.getDefaultMessage());
            errorModel = new ErrorModel();
            errorModel.setErrorCode(fieldError1.getCode());
            errorModel.setMessage(fieldError1.getDefaultMessage());
            errorModelList.add(errorModel);
        }
        return new ResponseEntity<>(errorModelList, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> businessExceptionHandler(BusinessException businessException){
        System.out.println("BusinessException is thrown");

        for(ErrorModel errorModel: businessException.getErrors()){
            logger.debug("BusinessException is thrown: {} - {}", errorModel.getErrorCode(), errorModel.getMessage());
            logger.info("BusinessException is thrown: {} - {}", errorModel.getErrorCode(), errorModel.getMessage());
            logger.warn("BusinessException is thrown: {} - {}", errorModel.getErrorCode(), errorModel.getMessage());
            logger.error("BusinessException is thrown: {} - {}", errorModel.getErrorCode(), errorModel.getMessage());
        }
        return new ResponseEntity<>(businessException.getErrors(), HttpStatus.NOT_FOUND);
    }
}
