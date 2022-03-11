package com.example.app.processor;

import com.example.shared.application.command.CommandHandler;
import com.example.shared.application.query.Query;
import com.example.shared.application.query.QueryBus;
import com.example.shared.application.query.QueryHandler;
import com.example.shared.infrastructure.SimpleQueryBus;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;

@Component
public class QueryBusProcessor implements BeanPostProcessor {
    private final SimpleQueryBus queryBus;

    @Autowired
    public QueryBusProcessor(SimpleQueryBus queryBus) {
        this.queryBus = queryBus;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(QueryBusComponent.class)) {
            QueryBusComponent annotation = bean.getClass().getAnnotation(QueryBusComponent.class);
            queryBus.register(annotation.classes(), (QueryHandler<? extends Query, ?>) bean);
        }

        return bean;
    }
}
