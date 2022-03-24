package com.example.user.domain.model;

import com.example.shared.domain.Model;
import com.example.user.infrastructure.persistence.converter.UserEmailConverter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="users")
public class User extends Model {
    @EmbeddedId
    private final UserId id;
    @Column(name = "email", unique = true, nullable = false, columnDefinition = "VARCHAR(255)")
    @Convert(converter = UserEmailConverter.class)
    private UserEmail email;

    public UserId getId() {
        return id;
    }

    private User(UserId id, UserEmail email) {
        super();
        this.id = id;
        this.email = email;
    }

    protected User(){
        this(null, null);
    }

    public User(UserId id, UserEmail email, LocalDateTime when) {
        this(id, email);
        apply(new UserWasCreated(id, email, when));
    }

    public UserId id() {
        return id;
    }

    public UserEmail email() {
        return email;
    }

    public void changeEmail(UserEmail newUserEmail, LocalDateTime when) {
        UserEmail oldEmail = email;
        email = newUserEmail;
        apply(new UserWasChangedEmail(id, oldEmail, newUserEmail, when));
    }
}
