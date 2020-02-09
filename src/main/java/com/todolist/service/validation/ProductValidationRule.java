package com.todolist.service.validation;

import com.todolist.domain.Product;

public interface ProductValidationRule {
    void validate(Product product);

    default void checkNotNull(Product product) {
        if (product == null) {
            throw new ProductValidationException("Task must be not null");
        }
    }
}
