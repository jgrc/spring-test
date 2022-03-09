package com.example.shared.domain.event;

public interface EventBus {
    void publish(Event event);
}
