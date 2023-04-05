package com.epicminds.training.exception;//package com.epicminds.demo.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
///**
// * @author Sidharth
// */
//@RestControllerAdvice
//public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler(value=ItemNotFoundException.class)
//    public ErrorResponse handleException(ItemNotFoundException ief){
//        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ief.getMessage());
//    }
//
//    @ExceptionHandler(value= NullPointerException.class)
//    public ErrorResponse handleException(NullPointerException ief){
//        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ief.getMessage());
//    }
//}
