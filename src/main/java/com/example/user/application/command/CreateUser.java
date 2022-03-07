package com.example.user.application.command;

import com.example.shared.application.Command;
import java.util.UUID;

public class CreateUser implements Command {
    private final UUID id;
    private final String email;

    public CreateUser(UUID id, String email) {
        this.id = id;
        this.email = email;
    }

    public UUID id() {
        return id;
    }

    public String email() {
        return email;
    }
}
