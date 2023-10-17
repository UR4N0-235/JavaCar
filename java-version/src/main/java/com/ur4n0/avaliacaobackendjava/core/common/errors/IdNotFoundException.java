package com.ur4n0.avaliacaobackendjava.core.common.errors;

public class IdNotFoundException extends RuntimeException {
    public IdNotFoundException(String message) {
        super(message);
    }
}
