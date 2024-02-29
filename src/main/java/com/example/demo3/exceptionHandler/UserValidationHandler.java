package com.example.demo3.exceptionHandler;

import com.example.demo3.exception.UserAlreadyExistsException;
import com.example.demo3.model.response.ValidationErrors;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
public class UserValidationHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrors>> handleValidationErrors(MethodArgumentNotValidException e){
        List<ValidationErrors> user = e.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> {
                    String message = "Invalid Request";
                    String cause = String.format("%s %s", fieldError.getField(), fieldError.getDefaultMessage());
                    return new ValidationErrors(message, cause);
                })
                .collect(Collectors.toList());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
    }
    
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ValidationErrors> handleUserValidationErrors(UserAlreadyExistsException e){

                    String message = "Invalid Request";
                    ValidationErrors validationErrors = new ValidationErrors(message, e.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(validationErrors);
    }
}
