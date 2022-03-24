package com.example.user.infrastructure.io.controller;

import com.example.shared.application.command.CommandBus;
import com.example.user.application.command.UpdateEmail;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PutUserController {
    private final CommandBus commandBus;

    @Autowired
    public PutUserController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @PutMapping(value = "/users/{userId}", consumes = {"application/json"})
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void action(@PathVariable String userId, @RequestBody JsonNode payload) {
        UpdateEmail command = new UpdateEmail(userId, payload.get("email").textValue());
        commandBus.dispatch(command);
    }
}
