package com.example.shared.infrastructure;

import com.example.shared.application.command.Command;
import com.example.shared.application.command.CommandBus;
import com.example.shared.application.command.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

@Component
public class SimpleCommandBus implements CommandBus {
    private Map<String, CommandHandler> handlers;

    @Autowired
    public SimpleCommandBus(ApplicationContext applicationContext) {
        handlers = new HashMap<>();
        Map<String, CommandHandler> components = applicationContext.getBeansOfType(CommandHandler.class);
        for (Map.Entry<String, CommandHandler> entry : components.entrySet()) {
            ParameterizedType handlerInterface = ((ParameterizedType) entry.getValue().getClass().getGenericInterfaces()[0]);
            String command = handlerInterface.getActualTypeArguments()[0].getTypeName();
            handlers.put(command, entry.getValue());
        }
    }

    @Override
    public void dispatch(Command command) {
        CommandHandler handler = handlers.get(command.getClass().getTypeName());
        handler.handle(command);
    }
}
