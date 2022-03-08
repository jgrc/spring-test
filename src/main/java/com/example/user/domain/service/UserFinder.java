package com.example.user.domain.service;

import com.example.user.domain.model.User;
import com.example.user.domain.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UserFinder {
    private final UserRepository userRepository;

    @Autowired
    public UserFinder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User get(String userId) {
        return userRepository.get(userId);
    }

    public List<User> all() {
        return userRepository.all();
    }
}
