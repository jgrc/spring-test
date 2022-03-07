package com.example.shared.domain;

import java.util.Collection;

public interface EventBus {
    void publish(Collection<Event> events);
}
