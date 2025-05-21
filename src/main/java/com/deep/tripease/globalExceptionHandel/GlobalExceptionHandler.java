package com.deep.tripease.globalExceptionHandel;

import com.deep.tripease.dto.response.CustomErrorResponse;
import com.deep.tripease.exception.CabNotAvailableException;
import com.deep.tripease.exception.CabNotFoundException;
import com.deep.tripease.exception.CustomerNotFoundException;
import com.deep.tripease.exception.DriverNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    //That endpoint handles all uncaught exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handelAllException(Exception ex){
        CustomErrorResponse errorResponse=new CustomErrorResponse("NOT_FOUND","Something went wrong,please try again latter");
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<?> handleCustomerNotFoundException(CustomerNotFoundException exception){
        CustomErrorResponse errorResponse=new CustomErrorResponse("NOT_FOUND",exception.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CabNotFoundException.class)
    public ResponseEntity<?> handleCustomerNotFoundException(CabNotFoundException exception){
        CustomErrorResponse errorResponse=new CustomErrorResponse("NOT_FOUND",exception.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CabNotAvailableException.class)
    public ResponseEntity<?> handleCustomerNotFoundException(CabNotAvailableException exception){
        CustomErrorResponse errorResponse=new CustomErrorResponse("NOT_FOUND",exception.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DriverNotFoundException.class)
    public ResponseEntity<?> handleCustomerNotFoundException(DriverNotFoundException exception){
        CustomErrorResponse errorResponse=new CustomErrorResponse("NOT_FOUND",exception.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }



}
