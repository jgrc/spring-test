package com.example.demo.application.query.product;

import com.example.demo.domain.model.product.Product;
import com.example.demo.domain.model.product.ProductRepository;
import com.example.shared.application.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class GetProductsQueryHandler implements QueryHandler<GetProducts, Collection<Product>> {
    private final ProductRepository productRepository;

    @Autowired
    public GetProductsQueryHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Collection<Product> handle(GetProducts $query) {
        return productRepository.all();
    }
}
