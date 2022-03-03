package com.example.demo.application.query.product;

import com.example.shared.application.Query;

public class GetProduct implements Query {
    private final Integer id;

    public GetProduct(Integer id) {
        this.id = id;
    }

    public Integer id() {
        return id;
    }
}
