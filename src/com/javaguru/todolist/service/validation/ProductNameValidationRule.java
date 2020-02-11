package com.javaguru.todolist.service.validation;

import com.javaguru.todolist.domain.Product;

public class ProductNameValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getName() == null) {
            throw new ProductValidationException("Task name must be not null.");
        }
    }
}
