package com.example.user.infrastructure.persistence;

import com.example.user.domain.model.User;
import com.example.user.domain.model.UserId;
import com.example.user.domain.model.UserNotFoundException;
import com.example.user.domain.model.UserRepository;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Component
public class InMemoryUserRepository implements UserRepository {
    private final Collection<User> users;

    public InMemoryUserRepository() {
        this.users = new ArrayList<>();
    }

    @Override
    public Collection<User> all() {
        return users;
    }

    @Override
    public User get(UserId id) throws UserNotFoundException {
        Optional<User> optional = users
            .stream()
            .filter(currentUser -> currentUser.id().equals(id))
            .findFirst();

        if (optional.isEmpty()) {
            throw UserNotFoundException.fromId(id);
        }

        return optional.get();
    }

    @Override
    public void save(User user) {
        users.add(user);
    }
}
