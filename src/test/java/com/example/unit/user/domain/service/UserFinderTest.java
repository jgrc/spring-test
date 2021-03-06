package com.example.unit.user.domain.service;

import com.example.stub.user.UserIdStub;
import com.example.stub.user.UserStub;
import com.example.user.domain.model.User;
import com.example.user.domain.model.UserId;
import com.example.user.domain.model.UserRepository;
import com.example.user.domain.service.UserFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserFinderTest {
    @Mock
    private UserRepository userRepository;
    private UserFinder sut;

    @BeforeEach
    public void setUp() {
        sut = new UserFinder(userRepository);
    }

    @Test
    public void testGetSuccess() {
        UserId id = new UserIdStub().build();
        User expectedUser = new UserStub().build();

        Mockito
                .when(userRepository.get(id))
                .thenReturn(expectedUser);

        Assertions.assertEquals(expectedUser, sut.get(id));
    }

    @Test
    public void testAllSuccess() {
        List<User> expectedUsers = List.of(new UserStub().build());

        Mockito
                .when(userRepository.all())
                .thenReturn(expectedUsers);

        Assertions.assertEquals(expectedUsers, sut.all());
    }
}
