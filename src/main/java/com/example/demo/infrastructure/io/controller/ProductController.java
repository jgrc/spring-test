package com.example.demo.infrastructure.io.controller;

import com.example.demo.application.query.product.GetProduct;
import com.example.demo.application.query.product.GetProductQueryHandler;
import com.example.demo.application.query.product.GetProducts;
import com.example.demo.application.query.product.GetProductsQueryHandler;
import com.example.demo.domain.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    @Autowired
    private final GetProductsQueryHandler getProductsQueryHandler;
    @Autowired
    private final GetProductQueryHandler getProductQueryHandler;

    public ProductController(GetProductsQueryHandler getProductsQueryHandler, GetProductQueryHandler getProductQueryHandler) {
        this.getProductsQueryHandler = getProductsQueryHandler;
        this.getProductQueryHandler = getProductQueryHandler;
    }

    @GetMapping("/products")
    public String all() {
        return getProductsQueryHandler
            .handle(new GetProducts())
            .stream()
            .map(this::serialice)
            .collect(Collectors.joining(",", "{", "}"));
    }

    @GetMapping("/products/{id}")
    public String detail(@PathVariable(value="id") final Integer id) {
        return serialice(getProductQueryHandler.handle(new GetProduct(id)));
    }

    private String serialice(Product product) {
        return String.format(
            "\"id\":\"%d\",\"name\":\"%s\",\"price\":\"%.2f\"",
            product.id(),
            product.name(),
            product.price()
        );
    }
}
