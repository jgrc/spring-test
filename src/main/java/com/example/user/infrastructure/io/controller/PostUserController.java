package com.example.user.infrastructure.io.controller;

import com.example.shared.application.command.CommandBus;
import com.example.shared.application.query.QueryBus;
import com.example.user.application.command.CreateUser;
import com.example.user.application.query.GetUserById;
import com.example.user.domain.model.User;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostUserController {
    private final CommandBus commandBus;

    @Autowired
    public PostUserController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @PostMapping(value = "/users", consumes = {"application/json"})
    @ResponseStatus(code = HttpStatus.CREATED)
    public void action(@RequestBody JsonNode payload) {
        CreateUser command = new CreateUser(payload.get("id").textValue(), payload.get("email").textValue());
        commandBus.dispatch(command);
    }
}
