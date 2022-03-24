package com.example.stub.user;

import com.example.stub.Faker;
import com.example.stub.Stub;
import com.example.user.domain.model.UserId;

import java.util.UUID;

public class UserIdStub implements Stub<UserId> {
    private String value;

    public UserIdStub() {
        value = Faker.uuid();
    }

    public UserIdStub withValue(String value) {
        this.value = value;

        return this;
    }

    public UserId build()  {
        return new UserId(value);
    }
}
