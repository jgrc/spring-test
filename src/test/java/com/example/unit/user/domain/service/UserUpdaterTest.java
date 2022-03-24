package com.example.unit.user.domain.service;

import com.example.shared.domain.event.Event;
import com.example.shared.domain.event.EventBus;
import com.example.stub.user.UserEmailStub;
import com.example.stub.user.UserIdStub;
import com.example.stub.user.UserStub;
import com.example.user.domain.model.User;
import com.example.user.domain.model.UserEmail;
import com.example.user.domain.model.UserId;
import com.example.user.domain.model.UserRepository;
import com.example.user.domain.model.UserWasChangedEmail;
import com.example.user.domain.service.UserUpdater;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserUpdaterTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private EventBus eventBus;
    private UserUpdater sut;

    @BeforeEach
    public void setUp() {
        sut = new UserUpdater(userRepository, eventBus);
    }

    @Test
    public void updateSuccess() {
        UserId id = new UserIdStub().build();
        User expectedUser = new UserStub().build();
        UserEmail newEmail = new UserEmailStub().build();

        Mockito
                .when(userRepository.get(id))
                .thenReturn(expectedUser);

        sut.update(id, newEmail);

        Mockito
                .verify(userRepository)
                .save(Mockito.argThat((User user) -> user.email().equals(newEmail)));
        Mockito
                .verify(eventBus)
                .publish(Mockito.argThat((Event event) -> event instanceof UserWasChangedEmail));
    }
}
