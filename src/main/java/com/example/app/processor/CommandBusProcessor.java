package com.example.app.processor;

import com.example.shared.application.command.CommandHandler;
import com.example.shared.infrastructure.SimpleCommandBus;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;

@Component
public class CommandBusProcessor implements BeanPostProcessor {
    private final SimpleCommandBus commandBus;

    @Autowired
    public CommandBusProcessor(SimpleCommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof CommandHandler) {
            ParameterizedType handlerInterface = ((ParameterizedType) bean.getClass().getGenericInterfaces()[0]);
            String command = handlerInterface.getActualTypeArguments()[0].getTypeName();
            commandBus.register(command, (CommandHandler<?>) bean);
        }

        return bean;
    }
}
