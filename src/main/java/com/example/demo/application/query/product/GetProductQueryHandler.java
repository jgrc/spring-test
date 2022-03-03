package com.example.demo.application.query.product;

import com.example.demo.domain.model.product.Product;
import com.example.demo.domain.model.product.ProductRepository;
import com.example.shared.application.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetProductQueryHandler implements QueryHandler<GetProduct, Product> {
    private final ProductRepository productRepository;

    @Autowired
    public GetProductQueryHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product handle(GetProduct query) {
        return productRepository.get(query.id());
    }
}
