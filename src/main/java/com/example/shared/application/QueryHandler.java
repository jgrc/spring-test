package com.example.shared.application;

public interface QueryHandler<Q extends Query, R> {
    R handle(Q query);
}
