package com.example.shared.domain;

import java.io.Serializable;

public interface Vo<T> extends Serializable {
    T value();
    boolean equals(Vo<T> other);
}
