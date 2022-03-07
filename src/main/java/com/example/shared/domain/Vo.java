package com.example.shared.domain;

interface Vo<T> {
    T value();
    boolean equals(Vo<T> other);
}
