package com.example.user.domain.model;

import com.example.shared.domain.NotFoundException;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(String message) {
        super(message);
    }

    public static UserNotFoundException fromId(String id) {
        return new UserNotFoundException(String.format("User with id '%s' not found.", id));
    }
}
