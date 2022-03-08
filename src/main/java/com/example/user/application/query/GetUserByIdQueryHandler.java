package com.example.user.application.query;

import com.example.user.domain.model.User;
import com.example.shared.application.QueryHandler;
import com.example.user.domain.service.UserFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserByIdQueryHandler implements QueryHandler<GetUserById, User> {
    private final UserFinder userFinder;

    @Autowired
    public GetUserByIdQueryHandler(UserFinder userFinder) {
        this.userFinder = userFinder;
    }

    @Override
    public User handle(GetUserById query) {
        return userFinder.get(query.id());
    }
}
