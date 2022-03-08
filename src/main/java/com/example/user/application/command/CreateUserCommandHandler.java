package com.example.user.application.command;

import com.example.shared.application.CommandHandler;
import com.example.user.domain.model.UserEmail;
import com.example.user.domain.service.UserCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserCommandHandler implements CommandHandler<CreateUser> {
    private final UserCreator userCreator;

    @Autowired
    public CreateUserCommandHandler(UserCreator userCreator) {
        this.userCreator = userCreator;
    }

    @Override
    public void handle(CreateUser command) {
        userCreator.create(command.id(), new UserEmail(command.email()));
    }
}
