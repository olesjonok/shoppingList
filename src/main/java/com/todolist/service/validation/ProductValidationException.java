package com.todolist.service.validation;

public class ProductValidationException extends NullPointerException {
    public ProductValidationException(String message) {
        super(message);
    }
}
