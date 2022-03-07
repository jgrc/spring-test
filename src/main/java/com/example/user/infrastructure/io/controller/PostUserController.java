package com.example.user.infrastructure.io.controller;

import com.example.user.application.command.CreateUser;
import com.example.user.application.command.CreateUserCommandHandler;
import com.example.user.application.query.GetUserById;
import com.example.user.application.query.GetUserByIdQueryHandler;
import com.example.user.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostUserController {
    private final CreateUserCommandHandler createUserCommandHandler;
    private final GetUserByIdQueryHandler getUserByIdQueryHandler;

    @Autowired
    public PostUserController(
        CreateUserCommandHandler createUserCommandHandler,
        GetUserByIdQueryHandler getUserByIdQueryHandler
    ) {
        this.createUserCommandHandler = createUserCommandHandler;
        this.getUserByIdQueryHandler = getUserByIdQueryHandler;
    }

    @PostMapping(value = "/users", consumes = {"application/json"})
    public String all(@RequestBody CreateUser command) {
        createUserCommandHandler.handle(command);
        User user = getUserByIdQueryHandler.handle(new GetUserById(command.id()));

        return String.format(
            "{\"id\":\"%S\",\"email\":\"%s\"}",
            user.id().value().toString(),
            user.email().value()
        );
    }
}
