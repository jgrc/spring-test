package com.example.user.application.query;

import com.example.app.processor.QueryBusComponent;
import com.example.user.domain.model.User;
import com.example.shared.application.query.QueryHandler;
import com.example.user.domain.model.UserId;
import com.example.user.domain.service.UserFinder;
import org.springframework.beans.factory.annotation.Autowired;

@QueryBusComponent(classes = GetUserById.class)
public class GetUserByIdQueryHandler implements QueryHandler<GetUserById, User> {
    private final UserFinder userFinder;

    @Autowired
    public GetUserByIdQueryHandler(UserFinder userFinder) {
        this.userFinder = userFinder;
    }

    @Override
    public User handle(GetUserById query) {
        return userFinder.get(new UserId(query.id()));
    }
}
