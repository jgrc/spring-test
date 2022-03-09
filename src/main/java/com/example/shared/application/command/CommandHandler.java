package com.example.shared.application.command;

public interface CommandHandler<C extends Command> {
    void handle(C command);
}
