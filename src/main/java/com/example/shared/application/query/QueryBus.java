package com.example.shared.application.query;

public interface QueryBus {
    Object dispatch(Query query);
}
