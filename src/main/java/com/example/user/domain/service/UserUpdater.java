package com.example.user.domain.service;

import com.example.shared.domain.event.EventBus;
import com.example.user.domain.model.User;
import com.example.user.domain.model.UserEmail;
import com.example.user.domain.model.UserId;
import com.example.user.domain.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserUpdater {
    private final UserRepository userRepository;
    private final EventBus eventBus;

    @Autowired
    public UserUpdater(
        UserRepository userRepository, EventBus eventBus) {
        this.userRepository = userRepository;
        this.eventBus = eventBus;
    }

    public void update(UserId id, UserEmail newEmail) {
        User user = userRepository.get(id);
        user.changeEmail(newEmail, LocalDateTime.now());
        userRepository.save(user);
        user.events().forEach(eventBus::publish);
    }
}
