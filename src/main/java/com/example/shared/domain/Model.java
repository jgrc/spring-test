package com.example.shared.domain;

import com.example.shared.domain.event.Event;
import java.util.ArrayList;
import java.util.List;

abstract public class Model {
    private final List<Event> events;

    public Model() {
        this.events = new ArrayList<>();
    }

    protected void apply(Event event) {
        events.add(event);
    }

    public List<Event> events() {
        List<Event> events = new ArrayList<>(this.events);
        this.events.clear();

        return events;
    }
}
