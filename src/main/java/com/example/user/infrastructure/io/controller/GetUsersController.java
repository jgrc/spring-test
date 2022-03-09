package com.example.user.infrastructure.io.controller;

import com.example.shared.application.query.QueryBus;
import com.example.user.application.query.GetUsers;
import com.example.user.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetUsersController {
    private final QueryBus queryBus;

    @Autowired
    public GetUsersController(QueryBus queryBus) {
        this.queryBus = queryBus;
    }

    @GetMapping("/users")
    public List<User> action() {
        return (List<User>) queryBus.dispatch(new GetUsers());
    }
}
