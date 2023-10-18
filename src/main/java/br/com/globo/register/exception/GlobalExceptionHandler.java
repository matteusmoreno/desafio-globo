package br.com.globo.register.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // Indica que a classe é um tratador de exceções
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidCepException.class)
    public ResponseEntity<String> handleInvalidCepException(InvalidCepException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
