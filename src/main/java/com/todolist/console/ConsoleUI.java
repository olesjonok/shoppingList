package com.todolist.console;

import com.todolist.domain.Product;
import com.todolist.service.ProductService;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleUI {
    private ProductService productService = new ProductService();

    public void execute() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Exit");
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        createProduct();
                        break;
                    case 2:
                        findProduct();
                        break;
                    case 3:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }

    private void createProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter product price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        System.out.println("Enter product category: ");
        String category = scanner.nextLine();
        System.out.println("Enter product discount: ");
        BigDecimal discount = new BigDecimal(scanner.nextLine());
        System.out.println("Enter product description: ");
        String description = scanner.nextLine();

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCategory(category);
        product.setDiscount(discount);
        product.setDescription(description);

        Long id = productService.createProduct(product);
        System.out.println("Id: " + id);
    }

    private void findProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter task id: ");
        Long id = scanner.nextLong();
        Product product = productService.findProductById(id);
        System.out.println(product);
    }

}
