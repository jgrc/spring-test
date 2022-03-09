package com.example.shared.application.command;

public interface CommandBus {
    void dispatch(Command command);
}
