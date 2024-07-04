package org.bshg.validation.typevalidators.array.impl;

import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.array.Lists;
import org.bshg.validation.utils.local.LocalUtils;
import org.bshg.validation.utils.local.errors.ArraysErrors;

import java.util.List;
import java.util.function.Predicate;

public class ListsImpl<T, TO> extends TypeValidatorImpl<List<T>, TO, Lists<T, TO>> implements Lists<T, TO> {
    protected ArraysErrors errors() {
        return LocalUtils.local().messages().array();
    }

    @Override
    public Lists<T, TO> required() {
        return onError(value -> value == null || value.isEmpty(), errors().required());
    }

    @Override
    public Lists<T, TO> minLength(int min) {
        return onError(value -> value == null || value.size() < min, errors().minSize(), new Object[]{min});
    }

    @Override
    public Lists<T, TO> maxLength(int max) {
        return onError(value -> value != null && value.size() > max, errors().maxSize(), new Object[]{max});
    }

    @Override
    public Lists<T, TO> lengthBetween(int min, int max) {
        return onError(
                value -> value == null || value.size() < min || value.size() > max,
                errors().sizeBetween(), new Object[]{min, max}
        );
    }

    @Override
    public Lists<T, TO> contains(T element) {
        return onError(
                value -> value == null || !value.contains(element),
                errors().contains(), new Object[]{element.toString()});
    }

    @Override
    public Lists<T, TO> satisfies(Predicate<T> predicate) {
        return onError(value -> value == null || value.stream().anyMatch(e -> !predicate.test(e)), errors().satisfies());
    }
}