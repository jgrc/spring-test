package com.example.bdd.steps;

import com.example.shared.application.command.CommandBus;
import com.example.user.application.command.CreateUser;
import com.example.user.domain.model.User;
import com.example.user.domain.model.UserId;
import com.example.user.domain.service.UserFinder;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class UserContext {
    private final CommandBus commandBus;
    private final UserFinder userFinder;

    @Autowired
    public UserContext(CommandBus commandBus, UserFinder userFinder) {
        this.commandBus = commandBus;
        this.userFinder = userFinder;
    }

    @Given("the following users:")
    public void followingUsers(DataTable table) {
        table
            .asMaps(String.class, String.class)
            .forEach(
                (Map<String, String> row) -> commandBus.dispatch(new CreateUser(row.get("id"), row.get("email")))
            );
    }

    @Then("the following users should exists:")
    public void followingUsersShouldExists(DataTable table) {
        table
            .asMaps(String.class, String.class)
            .forEach(
                (Map<String, String> row) -> {
                    User user = userFinder.get(new UserId(row.get("id")));
                    Assertions.assertEquals(row.get("email"), user.email().value());
                }
            );
    }
}
