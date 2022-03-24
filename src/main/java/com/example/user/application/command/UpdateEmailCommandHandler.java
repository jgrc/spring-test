package com.example.user.application.command;

import com.example.app.processor.CommandBusComponent;
import com.example.shared.application.command.CommandHandler;
import com.example.user.domain.model.UserEmail;
import com.example.user.domain.model.UserId;
import com.example.user.domain.service.UserUpdater;
import org.springframework.beans.factory.annotation.Autowired;

@CommandBusComponent(classes = UpdateEmail.class)
public class UpdateEmailCommandHandler implements CommandHandler<UpdateEmail> {
    private final UserUpdater userUpdater;

    @Autowired
    public UpdateEmailCommandHandler(UserUpdater userUpdater) {
        this.userUpdater = userUpdater;
    }

    @Override
    public void handle(UpdateEmail command) {
        userUpdater.update(new UserId(command.id()), new UserEmail(command.email()));
    }
}
