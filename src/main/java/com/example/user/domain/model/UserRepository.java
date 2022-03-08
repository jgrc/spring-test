package com.example.user.domain.model;

import java.util.List;

public interface UserRepository {
    List<User> all();
    User get(String id) throws UserNotFoundException;
    void save(User user);
}
