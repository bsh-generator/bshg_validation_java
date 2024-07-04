package org.bshg.validation.typevalidators.array.impl;

import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.array.Lists;

import java.util.List;
import java.util.function.Predicate;

public class ListsImpl<T, TO> extends TypeValidatorImpl<List<T>, TO, Lists<T, TO>> implements Lists<T, TO> {
    @Override
    public Lists<T, TO> required() {
        return onError(value -> value == null || value.isEmpty(), "This list is required");
    }

    @Override
    public Lists<T, TO> minLength(int min) {
        return onError(value -> value == null || value.size() < min, "List length must be at least " + min);
    }

    @Override
    public Lists<T, TO> maxLength(int max) {
        return onError(value -> value != null && value.size() > max, "List length must be at most " + max);
    }

    @Override
    public Lists<T, TO> lengthBetween(int min, int max) {
        return onError(value -> value == null || value.size() < min || value.size() > max, "List length must be between " + min + " and " + max);
    }

    @Override
    public Lists<T, TO> contains(T element) {
        return onError(value -> value == null || !value.contains(element), "List must contain element: " + element);
    }

    @Override
    public Lists<T, TO> satisfies(Predicate<T> predicate) {
        return onError(value -> value == null || value.stream().anyMatch(e -> !predicate.test(e)), "List elements must satisfy the provided predicate");
    }
}