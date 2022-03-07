package com.example.user.domain.model;

import com.example.shared.domain.Model;
import java.time.LocalDateTime;

public class User extends Model {
    private final UserId id;
    private final UserEmail email;

    public User(UserId id, UserEmail email) {
        super();
        this.id = id;
        this.email = email;
    }

    public User(UserId id, UserEmail email, LocalDateTime now) {
        this(id, email);
        apply(new UserWasCreated(id, now));
    }

    public UserId id() {
        return id;
    }

    public UserEmail email() {
        return email;
    }
}
