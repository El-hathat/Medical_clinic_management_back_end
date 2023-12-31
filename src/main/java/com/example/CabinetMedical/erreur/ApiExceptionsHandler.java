package com.example.CabinetMedical.erreur;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

/**
 * @author Khalid Elshafie <abolkog@gmail.com>
 * @Created 18/09/2018 10:32 PM.
 */
@ControllerAdvice
public class ApiExceptionsHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(ApiBaseException.class)
    public ResponseEntity<ErrorDetails> handleApiExceptions(ApiBaseException ex, WebRequest request){
        ErrorDetails details = new ErrorDetails(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(details, ex.getStatusCode());
    }

   
}
