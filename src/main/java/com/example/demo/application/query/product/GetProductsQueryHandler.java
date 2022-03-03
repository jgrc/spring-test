package com.example.demo.application.query.product;

import com.example.demo.domain.model.product.Product;
import com.example.demo.domain.model.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class GetProductsQueryHandler {
    @Autowired
    private final ProductRepository productRepository;

    public GetProductsQueryHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Collection<Product> handle(GetProducts $query) {
        return productRepository.all();
    }
}
