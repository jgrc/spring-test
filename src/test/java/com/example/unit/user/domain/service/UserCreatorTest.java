package com.example.unit.user.domain.service;

import com.example.shared.domain.event.Event;
import com.example.shared.domain.event.EventBus;
import com.example.user.domain.model.User;
import com.example.user.domain.model.UserEmail;
import com.example.user.domain.model.UserRepository;
import com.example.user.domain.model.UserWasCreated;
import com.example.user.domain.service.UserCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class UserCreatorTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private EventBus eventBus;
    private UserCreator sut;

    @BeforeEach
    public void setUp() {
        sut = new UserCreator(userRepository, eventBus);
    }

    @Test
    public void createSuccess() {
        String id = UUID.randomUUID().toString();
        UserEmail email = new UserEmail("random@ran.dom");
        sut.create(id, email);
        Mockito.verify(userRepository).save(
            Mockito.argThat((User user) -> user.id().equals(id) && user.email().equals(email))
        );
        Mockito.verify(eventBus).publish(
            Mockito.argThat((Event event) -> event instanceof UserWasCreated)
        );
    }
}
