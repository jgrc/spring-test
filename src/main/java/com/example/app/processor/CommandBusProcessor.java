package com.example.app.processor;

import com.example.shared.application.command.Command;
import com.example.shared.application.command.CommandHandler;
import com.example.shared.infrastructure.SimpleCommandBus;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CommandBusProcessor implements BeanPostProcessor {
    private final SimpleCommandBus commandBus;

    @Autowired
    public CommandBusProcessor(SimpleCommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(CommandBusComponent.class)) {
            CommandBusComponent annotation = bean.getClass().getAnnotation(CommandBusComponent.class);
            commandBus.register(annotation.classes(), (CommandHandler<? extends Command>) bean);
        }

        return bean;
    }
}
