package com.example.user.infrastructure.io.controller;

import com.example.shared.application.query.QueryBus;
import com.example.user.application.query.GetUserById;
import com.example.user.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetUserController {
    private final QueryBus queryBus;

    @Autowired
    public GetUserController(QueryBus queryBus) {
        this.queryBus = queryBus;
    }

    @GetMapping("/users/{userId}")
    public User action(@PathVariable String userId) {
        return (User) queryBus.dispatch(new GetUserById(userId));
    }
}
