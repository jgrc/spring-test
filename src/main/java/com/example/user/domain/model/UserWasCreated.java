package com.example.user.domain.model;

import com.example.shared.domain.event.Event;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserWasCreated implements Event {
    private final UserId id;
    private final UserEmail email;
    private final LocalDateTime on;

    public UserWasCreated(UserId id, UserEmail email, LocalDateTime on) {
        this.id = id;
        this.email = email;
        this.on = on;
    }

    public UserId id() {
        return id;
    }

    public UserEmail email() {
        return email;
    }

    public LocalDateTime on() {
        return on;
    }

    @Override
    public String toString() {
        return String.format(
            "[UserWasCreated, id='%s', email='%s', on='%s']",
            id.value(),
            email.value(),
            on.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        );
    }
}
