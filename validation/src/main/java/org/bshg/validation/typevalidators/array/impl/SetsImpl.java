package org.bshg.validation.typevalidators.array.impl;

import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.array.Sets;

import java.util.Set;
import java.util.function.Predicate;

public class SetsImpl<T, TO> extends TypeValidatorImpl<Set<T>, TO, Sets<T, TO>> implements Sets<T, TO> {
    @Override
    public Sets<T, TO> required() {
        return onError(value -> value == null || value.isEmpty(), "This set is required");
    }

    @Override
    public Sets<T, TO> minSize(int min) {
        return onError(value -> value == null || value.size() < min, "Set size must be at least " + min);
    }

    @Override
    public Sets<T, TO> maxSize(int max) {
        return onError(value -> value != null && value.size() > max, "Set size must be at most " + max);
    }

    @Override
    public Sets<T, TO> sizeBetween(int min, int max) {
        return onError(value -> value == null || value.size() < min || value.size() > max, "Set size must be between " + min + " and " + max);
    }

    @Override
    public Sets<T, TO> contains(T element) {
        return onError(value -> value == null || !value.contains(element), "Set must contain element: " + element);
    }

    @Override
    public Sets<T, TO> satisfies(Predicate<T> predicate) {
        return onError(value -> value == null || value.stream().anyMatch(e -> !predicate.test(e)), "Set elements must satisfy the provided predicate");
    }
}