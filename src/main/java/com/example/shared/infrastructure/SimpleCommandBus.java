package com.example.shared.infrastructure;

import com.example.shared.application.command.Command;
import com.example.shared.application.command.CommandBus;
import com.example.shared.application.command.CommandHandler;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SimpleCommandBus implements CommandBus {
    private final Map<String, CommandHandler<?>> handlers;

    public SimpleCommandBus() {
        this.handlers = new HashMap<>();
    }

    public void register(String command, CommandHandler<?> handler) {
        handlers.put(command, handler);
    }

    @Override
    public void dispatch(Command command) {
        CommandHandler handler = handlers.get(command.getClass().getTypeName());
        handler.handle(command);
    }
}
