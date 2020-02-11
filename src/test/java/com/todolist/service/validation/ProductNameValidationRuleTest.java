package com.todolist.service.validation;

import com.todolist.domain.Product;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProductNameValidationRuleTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    private ProductNameValidationRule victim = new ProductNameValidationRule();

    @Test
    public void shouldThrowTaskValidationException() {
        Product input = product(null);
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Task name must be not null.");
        victim.validate(input);
    }

    private Product product(String name) {
        Product product = new Product();
        product.setName(name);
        return product;
    }
}