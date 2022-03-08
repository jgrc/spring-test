package com.example.user.domain.model;

import com.example.shared.domain.Event;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserWasCreated implements Event {
    private final String id;
    private final LocalDateTime on;

    public UserWasCreated(String id, LocalDateTime on) {
        this.id = id;
        this.on = on;
    }

    public String id() {
        return id;
    }

    public LocalDateTime on() {
        return on;
    }

    @Override
    public String toString() {
        return String.format(
            "[UserWasCreated, id='%s', on='%s']",
            id,
            on.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        );
    }
}
