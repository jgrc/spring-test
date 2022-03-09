package com.example.shared.infrastructure;

import com.example.shared.domain.event.Event;
import com.example.shared.domain.event.EventBus;
import org.springframework.stereotype.Component;

@Component
public class SimpleEventBus implements EventBus {
    @Override
    public void publish(Event event) {
        System.out.println(event);
    }
}
