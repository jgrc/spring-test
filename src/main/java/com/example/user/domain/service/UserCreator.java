package com.example.user.domain.service;

import com.example.shared.domain.event.EventBus;
import com.example.user.domain.model.User;
import com.example.user.domain.model.UserEmail;
import com.example.user.domain.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class UserCreator {
    private final UserRepository userRepository;
    private final EventBus eventBus;

    @Autowired
    public UserCreator(
        UserRepository userRepository, EventBus eventBus) {
        this.userRepository = userRepository;
        this.eventBus = eventBus;
    }

    public void create(String id, UserEmail email) {
        User user = new User(id, email, LocalDateTime.now());
        userRepository.save(user);
        user.events().forEach(eventBus::publish);
    }
}
