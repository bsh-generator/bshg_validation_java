package org.bshg.validation.typevalidators.array;

import org.bshg.validation.typevalidators.TypeValidator;

import java.util.List;
import java.util.function.Predicate;

public interface Lists<T, TO> extends TypeValidator<List<T>, TO, Lists<T, TO>> {
    Lists<T, TO> required();
    Lists<T, TO> minLength(int min);
    Lists<T, TO> maxLength(int max);
    Lists<T, TO> lengthBetween(int min, int max);
    Lists<T, TO> contains(T element);
    Lists<T, TO> satisfies(Predicate<T> predicate);
}