package com.example.demo.domain.model.product;

import java.util.Collection;
import java.util.Optional;

public interface ProductRepository {
    Collection<Product> all();
    Product get(Integer id);
}
