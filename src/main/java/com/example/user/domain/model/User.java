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
    private final UserEmail email;

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

    public User(UserId id, UserEmail email, LocalDateTime now) {
        this(id, email);
        apply(new UserWasCreated(id, now));
    }

    public UserId id() {
        return id;
    }

    public UserEmail email() {
        return email;
    }
}
