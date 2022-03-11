package com.example.user.application.command;

import com.example.app.processor.CommandBusComponent;
import com.example.shared.application.command.CommandHandler;
import com.example.user.domain.model.UserEmail;
import com.example.user.domain.service.UserCreator;
import org.springframework.beans.factory.annotation.Autowired;

@CommandBusComponent(classes = CreateUser.class)
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
