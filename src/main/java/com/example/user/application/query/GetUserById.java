package com.example.user.application.query;

import com.example.shared.application.Query;

public class GetUserById implements Query {
    private final String id;

    public GetUserById(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
