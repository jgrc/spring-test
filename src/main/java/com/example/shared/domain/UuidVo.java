package com.example.shared.domain;

import java.util.UUID;

abstract public class UuidVo implements Vo<UUID> {
    private final UUID value;

    public UuidVo(UUID value) {
        this.value = value;
    }

    @Override
    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Vo<UUID> other) {
        return getClass().equals(other.getClass()) && value.equals(other.value());
    }
}
