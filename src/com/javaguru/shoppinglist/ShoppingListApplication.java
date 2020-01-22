package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {
        Map<Long, Product> productRepository = new HashMap<>();
        Long productIdSequence = 0L;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        String name;
                        do {
                            System.out.println("Enter product name: ");
                            name = scanner.nextLine();
                        } while (name.length() < 3 || name.length() > 32);
                        BigDecimal price;
                        do {
                            System.out.println("Enter product price: ");
                            price = new BigDecimal(scanner.nextLine());
                        } while (price.signum() == -1);
                        System.out.println("Enter product category: ");
                        String category = scanner.nextLine();
                        int discount;
                        do {
                            System.out.println("Enter product discount: ");
                            discount = Integer.parseInt(scanner.nextLine());
                        } while (discount > 100 || discount < 0);
                        System.out.println("Enter product description: ");
                        String description = scanner.nextLine();
                        Product product = new Product();
                        product.setName(name);
                        product.setPrice(price);
                        product.setCategory(category);
                        product.setDiscount(discount);
                        product.setDescription(description);
                        product.setId(productIdSequence);
                        productRepository.put(productIdSequence, product);
                        productIdSequence++;
                        System.out.println("Result: " + product.getId());
                        break;
                    case 2:
                        System.out.println("Enter product id: ");
                        long id = scanner.nextLong();
                        Product findProductResult = productRepository.get(id);
                        System.out.println(findProductResult);
                        break;
                    case 3:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }
}
