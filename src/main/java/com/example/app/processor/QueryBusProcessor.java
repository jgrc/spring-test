package com.example.app.processor;

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
        if (bean instanceof QueryHandler) {
            ParameterizedType handlerInterface = ((ParameterizedType) bean.getClass().getGenericInterfaces()[0]);
            String query = handlerInterface.getActualTypeArguments()[0].getTypeName();
            queryBus.register(query, (QueryHandler<?, ?>) bean);
        }

        return bean;
    }
}
