package com.example.user.infrastructure.io.controller;

import com.example.shared.application.command.CommandBus;
import com.example.shared.application.query.QueryBus;
import com.example.user.application.command.CreateUser;
import com.example.user.application.query.GetUserById;
import com.example.user.domain.model.User;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostUserController {
    private final CommandBus commandBus;
    private final QueryBus queryBus;

    @Autowired
    public PostUserController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PostMapping(value = "/users", consumes = {"application/json"})
    public User action(@RequestBody JsonNode payload) {
        CreateUser command = new CreateUser(payload.get("id").textValue(), payload.get("email").textValue());
        commandBus.dispatch(command);

        return (User) queryBus.dispatch(new GetUserById(command.id()));
    }
}
