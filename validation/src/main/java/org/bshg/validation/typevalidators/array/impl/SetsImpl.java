package org.bshg.validation.typevalidators.array.impl;

import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.array.Sets;
import org.bshg.validation.utils.local.LocalUtils;
import org.bshg.validation.utils.local.errors.ArraysErrors;

import java.util.Set;
import java.util.function.Predicate;

public class SetsImpl<T, TO> extends TypeValidatorImpl<Set<T>, TO, Sets<T, TO>> implements Sets<T, TO> {
    protected ArraysErrors errors() {
        return LocalUtils.local().messages().array();
    }

    @Override
    public Sets<T, TO> required() {
        return onError(value -> value == null || value.isEmpty(), errors().required());
    }

    @Override
    public Sets<T, TO> minSize(int min) {
        return onError(value -> value == null || value.size() < min, errors().minSize(), new Object[]{min});
    }

    @Override
    public Sets<T, TO> maxSize(int max) {
        return onError(value -> value != null && value.size() > max, errors().maxSize(), new Object[]{max});
    }

    @Override
    public Sets<T, TO> sizeBetween(int min, int max) {
        return onError(
                value -> value == null || value.size() < min || value.size() > max,
                errors().sizeBetween(), new Object[]{min, max}
        );
    }

    @Override
    public Sets<T, TO> contains(T element) {
        return onError(
                value -> value == null || !value.contains(element),
                errors().contains(), new Object[]{element.toString()}
        );
    }

    @Override
    public Sets<T, TO> satisfies(Predicate<T> predicate) {
        return onError(
                value -> value == null || value.stream().anyMatch(e -> !predicate.test(e)),
                errors().satisfies()
        );
    }
}