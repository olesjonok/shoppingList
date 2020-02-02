package com.javaguru.todolist.service.validation;

public class ProductValidationException extends NullPointerException {
    public ProductValidationException(String message) {
        System.out.println(message);
    }
}
