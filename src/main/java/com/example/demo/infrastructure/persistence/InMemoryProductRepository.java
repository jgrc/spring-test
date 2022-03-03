package com.example.demo.infrastructure.persistence;

import com.example.demo.domain.model.product.Product;
import com.example.demo.domain.model.product.ProductNotFoundException;
import com.example.demo.domain.model.product.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

@Component
public class InMemoryProductRepository implements ProductRepository {
    private final Collection<Product> products;

    public InMemoryProductRepository() {
        this.products = Arrays.asList(
            new Product(1, "Olives", 2.45f),
            new Product(2, "Beer", 3.55f),
            new Product(3, "Chips", .95f)
        );
    }

    @Override
    public Collection<Product> all() {
        return products;
    }

    @Override
    public Product get(Integer id) {
        Optional<Product> optional = products
            .stream()
            .filter(tempProduct -> tempProduct.id().equals(id))
            .findFirst();

        if (optional.isEmpty()) {
            throw ProductNotFoundException.fromId(id);
        }

        return optional.get();
    }
}
