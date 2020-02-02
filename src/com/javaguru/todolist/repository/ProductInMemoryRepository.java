package com.javaguru.todolist.repository;

import com.javaguru.todolist.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductInMemoryRepository {
    private Long TASK_ID_SEQUENCE = 0L;
    private Map<Long, Product> products = new HashMap<>();

    public Product insert(Product product) {
        product.setId(TASK_ID_SEQUENCE);
        products.put(TASK_ID_SEQUENCE, product);
        TASK_ID_SEQUENCE++;
        return product;
    }

    public Product findProductById(Long id) {
        return products.get(id);
    }
}
