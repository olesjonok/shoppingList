package com.todolist.service;

import com.todolist.domain.Product;
import com.todolist.repository.ProductInMemoryRepository;
import com.todolist.service.validation.ProductValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductInMemoryRepository repository;
    @Mock
    private ProductValidationService validationService;

    @InjectMocks
    private ProductService victim;

    @Captor
    private ArgumentCaptor<Product> productCaptor;

    @Test
    public void shouldFindTask() {
        when(repository.findProductById(1001L)).thenReturn(buildProduct());
        Product result = victim.findProductById(1001L);
        assertEquals(buildProduct(), result);
    }

    @Test
    public void shouldCreateProductSuccessfully() {
        Product product = buildProduct();
        when(repository.insert(product)).thenReturn(product);
        Long result = victim.createProduct(product);
        verify(validationService).validate(productCaptor.capture());
        Product captorResult = productCaptor.getValue();
        assertEquals(captorResult, product);
        assertEquals(product.getId(), result);
    }

    private Product buildProduct() {
        Product product = new Product();
        product.setName("TEST_NAME");
        BigDecimal price = new BigDecimal("0.03");
        product.setPrice(price);
        product.setCategory("TEST_CATEGORY");
        BigDecimal discount = new BigDecimal("0.56");
        product.setDiscount(discount);
        product.setDescription("TEST_DESCRIPTION");
        product.setId(1001L);
        return product;
    }
}
