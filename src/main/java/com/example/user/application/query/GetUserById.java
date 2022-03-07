package com.example.user.application.query;

import com.example.shared.application.Query;
import java.util.UUID;

public class GetUserById implements Query {
    private final UUID id;

    public GetUserById(UUID id) {
        this.id = id;
    }

    public UUID id() {
        return id;
    }
}
