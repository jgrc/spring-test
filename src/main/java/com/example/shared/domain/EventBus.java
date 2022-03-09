package com.example.shared.domain;

public interface EventBus {
    void publish(Event event);
}
