package org.bshg.validation.typevalidators.array;

import org.bshg.validation.typevalidators.TypeValidator;

import java.util.Set;
import java.util.function.Predicate;

public interface Sets<T, TO> extends TypeValidator<Set<T>, TO, Sets<T, TO>> {
    Sets<T, TO> required();
    Sets<T, TO> minSize(int min);
    Sets<T, TO> maxSize(int max);
    Sets<T, TO> sizeBetween(int min, int max);
    Sets<T, TO> contains(T element);
    Sets<T, TO> satisfies(Predicate<T> predicate);
}