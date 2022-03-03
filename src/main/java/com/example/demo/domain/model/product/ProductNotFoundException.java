package com.example.demo.domain.model.product;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }

    public static ProductNotFoundException fromId(Integer id) {
        return new ProductNotFoundException(String.format("Product %d not found", id));
    }
}
