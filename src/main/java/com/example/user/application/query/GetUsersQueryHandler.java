package com.example.user.application.query;

import com.example.app.processor.QueryBusComponent;
import com.example.user.domain.model.User;
import com.example.shared.application.query.QueryHandler;
import com.example.user.domain.service.UserFinder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@QueryBusComponent(classes = GetUsers.class)
public class GetUsersQueryHandler implements QueryHandler<GetUsers, List<User>> {
    private final UserFinder userFinder;

    @Autowired
    public GetUsersQueryHandler(UserFinder userFinder) {
        this.userFinder = userFinder;
    }

    @Override
    public List<User> handle(GetUsers $query) {
        return userFinder.all();
    }
}
