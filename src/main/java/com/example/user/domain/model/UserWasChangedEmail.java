package com.example.user.domain.model;

import com.example.shared.domain.event.Event;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserWasChangedEmail implements Event {
    private final UserId id;
    private final UserEmail oldEmail;
    private final UserEmail newEmail;
    private final LocalDateTime on;

    public UserWasChangedEmail(UserId id, UserEmail oldEmail, UserEmail newEmail, LocalDateTime on) {
        this.id = id;
        this.oldEmail = oldEmail;
        this.newEmail = newEmail;
        this.on = on;
    }

    public UserId id() {
        return id;
    }

    public UserEmail oldEmail() {
        return oldEmail;
    }

    public UserEmail newEmail() {
        return newEmail;
    }

    public LocalDateTime on() {
        return on;
    }

    @Override
    public String toString() {
        return String.format(
            "[UserWasChangedEmail, id='%s', old_email='%s', new_email='%s', on='%s']",
            id.value(),
            oldEmail.value(),
            newEmail.value(),
            on.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        );
    }
}
