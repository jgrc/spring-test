package com.example.stub.user;

import com.example.stub.Stub;
import com.example.user.domain.model.User;
import com.example.user.domain.model.UserEmail;
import com.example.user.domain.model.UserId;

import java.time.LocalDateTime;

public class UserStub implements Stub<User> {
    private UserId id;
    private UserEmail email;

    public UserStub() {
        this
            .withId(new UserIdStub().build())
            .withEmail(new UserEmailStub().build());
    }

    public UserStub withId(UserId id) {
        this.id = id;

        return this;
    }

    public UserStub withEmail(UserEmail email) {
        this.email = email;

        return this;
    }

    public User build() {
        User user = new User(id, email, LocalDateTime.now());
        user.events();

        return user;
    }
}
