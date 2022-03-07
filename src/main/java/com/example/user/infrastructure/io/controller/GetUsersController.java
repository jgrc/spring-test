package com.example.user.infrastructure.io.controller;

import com.example.user.application.query.GetUsers;
import com.example.user.application.query.GetUsersQueryHandler;
import com.example.user.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;

@RestController
public class GetUsersController {
    private final GetUsersQueryHandler handler;

    @Autowired
    public GetUsersController(GetUsersQueryHandler handler) {
        this.handler = handler;
    }

    @GetMapping("/users")
    public Collection<User> action() {
        return handler.handle(new GetUsers());
    }
}
