package com.example.shared.domain;

abstract public class StringVo implements Vo<String> {
    private final String value;

    public StringVo(String value) {
        this.guard(value);
        this.value = value;
    }

    public void guard(String value) {
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Vo<String> other) {
        return getClass().equals(other.getClass()) && value.equals(other.value());
    }
}
