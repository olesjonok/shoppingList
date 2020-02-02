package com.javaguru.todolist.console;

import com.javaguru.todolist.domain.Product;
import com.javaguru.todolist.repository.ProductInMemoryRepository;
import com.javaguru.todolist.service.ProductService;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleUI {
    private final ProductService productService;

    public ConsoleUI(ProductService productService) {
        this.productService = productService;
    }

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
        String name;
        do {
            System.out.println("Enter product name: ");
            name = scanner.nextLine();
            System.out.println("Product name can't be less than 3 and more than 32 symbols!");
        } while (name.length() < 3 || name.length() > 32);
        BigDecimal price;
        do {
            System.out.println("Enter product price: ");
            price = new BigDecimal(scanner.nextLine());
            System.out.println("Product price can't be negative!");
        } while (price.signum() == -1);
        System.out.println("Enter product category: ");
        String category = scanner.nextLine();
        int discount;
        do {
            System.out.println("Enter product discount: ");
            discount = Integer.parseInt(scanner.nextLine());
            System.out.println("Product discount can't be less than 0% and more than 100%!");
        } while (discount > 100 || discount < 0);
        System.out.println("Enter product description: ");
        String description = scanner.nextLine();

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCategory(category);
        product.setDiscount(discount);
        product.setDescription(description);

        Long id = productService.createProduct(product);
        System.out.println("Result: " + id);
    }

    private void findProduct() {
        ProductInMemoryRepository productInMemoryRepository = new ProductInMemoryRepository();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter task id: ");
        Long id = scanner.nextLong();
        Product product = productInMemoryRepository.findProductById(id);
        System.out.println(product);
    }

}
