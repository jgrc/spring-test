package com.example.user.domain.model;

import com.example.shared.domain.Model;
import com.example.user.infrastructure.persistence.converter.UserEmailConverter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="users")
public class User extends Model {
    @Id
    @Column(name = "id", columnDefinition = "CHAR", length = 36)
    private final String id;
    @Column(name = "email", unique = true, nullable = false, columnDefinition = "VARCHAR", length = 255)
    @Convert(converter = UserEmailConverter.class)
    private final UserEmail email;

    public User(){
        this(null, null);
    }

    public User(String id, UserEmail email) {
        super();
        this.id = id;
        this.email = email;
    }

    public User(String id, UserEmail email, LocalDateTime now) {
        this(id, email);
        apply(new UserWasCreated(id, now));
    }

    public String id() {
        return id;
    }

    public UserEmail email() {
        return email;
    }
}
