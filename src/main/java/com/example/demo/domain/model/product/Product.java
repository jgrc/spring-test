package com.example.demo.domain.model.product;

public class Product {
    private final Integer id;
    private final String name;
    private final Float price;

    public Product(Integer id, String name, Float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Float price() {
        return price;
    }
}
