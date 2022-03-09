package com.example.shared.infrastructure;

import com.example.shared.domain.Event;
import com.example.shared.domain.EventBus;
import org.springframework.stereotype.Component;

@Component
public class SimpleEventBus implements EventBus {
    @Override
    public void publish(Event event) {
        System.out.println(event);
    }
}
