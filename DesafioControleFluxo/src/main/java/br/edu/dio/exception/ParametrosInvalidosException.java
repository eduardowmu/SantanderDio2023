package br.edu.dio.exception;

public class ParametrosInvalidosException extends RuntimeException {
    private String message;

    public ParametrosInvalidosException(String message) {
        super(message);
    }
}