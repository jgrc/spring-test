package com.example.shared.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Collection;

abstract public class Model {
    private final Collection<Event> events;

    public Model() {
        this.events = new ArrayList<>();
    }

    protected void apply(Event event) {
        events.add(event);
    }

    public Collection<Event> events() {
        Collection<Event> events = new ArrayList<>(this.events);
        this.events.clear();

        return events;
    }
}
