package com.example.shared.domain;

import java.util.regex.Pattern;

abstract public class EmailVo extends StringVo {
    private static final String PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    public EmailVo(String value) {
        super(value);
    }

    @Override
    public void guard(String value) {
        Pattern regex = Pattern.compile(PATTERN);
        if (value == null || !regex.matcher(value).matches()) {
            throw new IllegalArgumentException(String.format("Value '%s' is not a valid email", value));
        }
    }
}
