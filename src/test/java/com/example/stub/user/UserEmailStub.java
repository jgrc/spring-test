package com.example.stub.user;

import com.example.stub.Faker;
import com.example.stub.Stub;
import com.example.user.domain.model.UserEmail;

public class UserEmailStub implements Stub<UserEmail> {
    private String value;

    public UserEmailStub() {
        value = Faker.email();
    }

    public UserEmailStub withValue(String value) {
        this.value = value;

        return this;
    }

    public UserEmail build()  {
        return new UserEmail(value);
    }
}
