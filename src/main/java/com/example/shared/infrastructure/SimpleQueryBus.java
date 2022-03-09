package com.example.shared.infrastructure;

import com.example.shared.application.query.Query;
import com.example.shared.application.query.QueryBus;
import com.example.shared.application.query.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

@Component
public class SimpleQueryBus implements QueryBus {
    private Map<String, QueryHandler> handlers;

    @Autowired
    public SimpleQueryBus(ApplicationContext applicationContext) {
        handlers = new HashMap<>();
        Map<String, QueryHandler> components = applicationContext.getBeansOfType(QueryHandler.class);
        for (Map.Entry<String, QueryHandler> entry : components.entrySet()) {
            ParameterizedType handlerInterface = ((ParameterizedType) entry.getValue().getClass().getGenericInterfaces()[0]);
            String query = handlerInterface.getActualTypeArguments()[0].getTypeName();
            handlers.put(query, entry.getValue());
        }
    }

    @Override
    public Object dispatch(Query query) {
        QueryHandler handler = handlers.get(query.getClass().getTypeName());
        return handler.handle(query);
    }
}
