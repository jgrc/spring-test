package com.example.user.infrastructure.io.controller;

import com.example.user.application.query.GetUsers;
import com.example.user.application.query.GetUsersQueryHandler;
import com.example.user.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;

@RestController
public class GetUsersController {
    private final GetUsersQueryHandler handler;

    @Autowired
    public GetUsersController(GetUsersQueryHandler handler) {
        this.handler = handler;
    }

    @GetMapping("/users")
    public String action() {
        return handler
            .handle(new GetUsers())
            .stream()
            .map(this::serialice)
            .collect(Collectors.joining(",", "[", "]"));
    }

    private String serialice(User user) {
        return String.format(
            "{\"id\":\"%S\",\"email\":\"%s\"}",
            user.id().value().toString(),
            user.email().value()
        );
    }
}
