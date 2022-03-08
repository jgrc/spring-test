package com.example.shared.infrastructure;

import com.example.shared.domain.Event;
import com.example.shared.domain.EventBus;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class SimpleEventBus implements EventBus {
    @Override
    public void publish(List<Event> events) {
        events.forEach(System.out::println);
    }
}
