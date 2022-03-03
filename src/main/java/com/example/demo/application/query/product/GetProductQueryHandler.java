package com.example.demo.application.query.product;

import com.example.demo.domain.model.product.Product;
import com.example.demo.domain.model.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetProductQueryHandler {
    @Autowired
    private final ProductRepository productRepository;

    public GetProductQueryHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product handle(GetProduct query) {
        return productRepository.get(query.id());
    }
}
