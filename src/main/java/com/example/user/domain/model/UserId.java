package com.example.user.domain.model;

import com.example.shared.domain.Vo;

import javax.persistence.Column;
import java.util.regex.Pattern;

public class UserId implements Vo<String> {

    private static final String PATTERN = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$";

    @Column(name = "id", nullable = false, columnDefinition = "CHAR(36)")
    private final String value;

    protected UserId() {
        value = null;
    }

    public UserId(String value) {
        guard(value.toLowerCase());
        this.value = value.toLowerCase();
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
            throw new IllegalArgumentException(String.format("Value '%s' is not a valid uuid", value));
        }
    }
}
