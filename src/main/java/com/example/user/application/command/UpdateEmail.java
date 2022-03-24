package com.example.user.application.command;

import com.example.shared.application.command.Command;

public class UpdateEmail implements Command {
    private final String id;
    private final String email;

    public UpdateEmail(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String id() {
        return id;
    }

    public String email() {
        return email;
    }
}
