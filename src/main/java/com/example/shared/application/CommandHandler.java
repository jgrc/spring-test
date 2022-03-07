package com.example.shared.application;

public interface CommandHandler<C extends Command> {
    void handle(C command);
}
