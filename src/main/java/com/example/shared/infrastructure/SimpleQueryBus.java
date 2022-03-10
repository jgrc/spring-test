package com.example.shared.infrastructure;

import com.example.shared.application.query.Query;
import com.example.shared.application.query.QueryBus;
import com.example.shared.application.query.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SimpleQueryBus implements QueryBus {
    private final Map<String, QueryHandler<?, ?>> handlers;

    public SimpleQueryBus() {
        this.handlers = new HashMap<>();
    }

    public void register(String query, QueryHandler<?, ?> handler) {
        handlers.put(query, handler);
    }

    @Override
    public Object dispatch(Query query) {
        QueryHandler handler = handlers.get(query.getClass().getTypeName());
        return handler.handle(query);
    }
}
