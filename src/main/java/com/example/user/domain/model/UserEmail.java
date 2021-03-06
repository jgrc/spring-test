package com.example.user.domain.model;

import com.example.shared.domain.Vo;

import java.util.regex.Pattern;

public class UserEmail implements Vo<String> {
    private static final String PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private final String value;

    public UserEmail(String value) {
        guard(value);
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Vo<String> other) {
        return getClass().equals(other.getClass()) && value.equals(other.value());
    }

    private void guard(String value) {
        Pattern regex = Pattern.compile(PATTERN);
        if (value == null || !regex.matcher(value).matches()) {
            throw new IllegalArgumentException(String.format("Value '%s' is not a valid email", value));
        }
    }
}
