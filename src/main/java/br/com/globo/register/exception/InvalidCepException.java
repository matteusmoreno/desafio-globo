package br.com.globo.register.exception;

public class InvalidCepException extends RuntimeException{
    public InvalidCepException(String message) {
        super(message);
    }
}
