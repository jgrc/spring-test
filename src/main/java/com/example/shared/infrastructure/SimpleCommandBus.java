package com.example.shared.infrastructure;

import com.example.shared.application.command.Command;
import com.example.shared.application.command.CommandBus;
import com.example.shared.application.command.CommandHandler;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SimpleCommandBus implements CommandBus {
    private final Map<Class<? extends Command>, CommandHandler<? extends Command>> handlers;

    public SimpleCommandBus() {
        this.handlers = new HashMap<>();
    }

    public void register(Class<? extends Command> command, CommandHandler<? extends Command> handler) {
        handlers.put(command, handler);
    }

    @Override
    public void dispatch(Command command) {
        CommandHandler handler = handlers.get(command.getClass());
        handler.handle(command);
    }
}
