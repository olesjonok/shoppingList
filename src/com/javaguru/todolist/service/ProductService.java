package com.javaguru.todolist.service;

import com.javaguru.todolist.domain.Product;
import com.javaguru.todolist.repository.ProductInMemoryRepository;
import com.javaguru.todolist.service.validation.ProductValidationService;

public class ProductService {
//    private ProductInMemoryRepository repository = new ProductInMemoryRepository();
//    private ProductValidationService validationService = new ProductValidationService();

    private final ProductInMemoryRepository repository;
    private final ProductValidationService validationService;

    public ProductService(ProductInMemoryRepository repository,
                          ProductValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    public Long createProduct(Product product) {
        validationService.validate(product);
        Product createdProduct = repository.insert(product);
        return createdProduct.getId();
    }
}
