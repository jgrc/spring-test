package com.example.user.domain.model;

import java.util.List;

public interface UserRepository {
    List<User> all();
    User get(UserId id) throws UserNotFoundException;
    void save(User user);
}
