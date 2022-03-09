package com.example.user.infrastructure.io.controller;

import com.example.shared.application.command.CommandBus;
import com.example.user.application.command.CreateUser;
import com.example.user.application.query.GetUserById;
import com.example.user.application.query.GetUserByIdQueryHandler;
import com.example.user.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostUserController {
    private final CommandBus commandBus;
    private final GetUserByIdQueryHandler getUserByIdQueryHandler;

    @Autowired
    public PostUserController(
        CommandBus commandBus,
        GetUserByIdQueryHandler getUserByIdQueryHandler
    ) {
        this.commandBus = commandBus;
        this.getUserByIdQueryHandler = getUserByIdQueryHandler;
    }

    @PostMapping(value = "/users", consumes = {"application/json"})
    public User action(@RequestBody CreateUser command) {
        commandBus.dispatch(command);
        return getUserByIdQueryHandler.handle(new GetUserById(command.id()));
    }
}
