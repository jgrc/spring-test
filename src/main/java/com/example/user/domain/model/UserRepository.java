package com.example.user.domain.model;

import java.util.Collection;

public interface UserRepository {
    Collection<User> all();
    User get(UserId id) throws UserNotFoundException;
    void save(User user);
}
