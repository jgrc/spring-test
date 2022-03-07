package com.example.user.domain.model;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }

    public static UserNotFoundException fromId(UserId id) {
        return new UserNotFoundException(String.format("User with id '%s' not found.", id.value()));
    }
}
