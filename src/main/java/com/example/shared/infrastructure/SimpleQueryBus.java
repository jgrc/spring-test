package com.example.shared.infrastructure;

import com.example.shared.application.query.Query;
import com.example.shared.application.query.QueryBus;
import com.example.shared.application.query.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SimpleQueryBus implements QueryBus {
    private final Map<Class<? extends Query>, QueryHandler<? extends Query, ?>> handlers;

    public SimpleQueryBus() {
        this.handlers = new HashMap<>();
    }

    public void register(Class<? extends Query> query, QueryHandler<? extends Query, ?> handler) {
        handlers.put(query, handler);
    }

    @Override
    public Object dispatch(Query query) {
        QueryHandler handler = handlers.get(query.getClass());
        return handler.handle(query);
    }
}
