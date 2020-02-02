package com.javaguru.todolist.service.validation;

import com.javaguru.todolist.domain.Product;

public interface ProductValidationRule {
    void validate(Product product);

    default void checkNotNull(Product product) {
        if (product == null) {
            throw new ProductValidationException("Task must be not null");
        }
    }
}
