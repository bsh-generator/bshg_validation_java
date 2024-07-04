package org.bshg.validation.typevalidators.array;

import org.bshg.validation.typevalidators.TypeValidator;

import java.util.List;
import java.util.function.Predicate;

/**
 * Interface defining validation methods for List values.
 *
 * @param <T> The type of elements in the List.
 * @param <TO> The type of object to validate.
 */
public interface Lists<T, TO> extends TypeValidator<List<T>, TO, Lists<T, TO>> {

    /**
     * Specifies that the List must not be null or empty.
     *
     * @return The current instance of the validator.
     */
    Lists<T, TO> required();

    /**
     * Specifies the minimum length required for the List.
     *
     * @param min Minimum length allowed.
     * @return The current instance of the validator.
     */
    Lists<T, TO> minLength(int min);

    /**
     * Specifies the maximum length allowed for the List.
     *
     * @param max Maximum length allowed.
     * @return The current instance of the validator.
     */
    Lists<T, TO> maxLength(int max);

    /**
     * Specifies a range of allowed lengths (inclusive) for the List.
     *
     * @param min Minimum length allowed.
     * @param max Maximum length allowed.
     * @return The current instance of the validator.
     */
    Lists<T, TO> lengthBetween(int min, int max);

    /**
     * Specifies that the List must contain a specific element.
     *
     * @param element Element that must be present in the List.
     * @return The current instance of the validator.
     */
    Lists<T, TO> contains(T element);

    /**
     * Specifies that all elements in the List must satisfy a given predicate.
     *
     * @param predicate Predicate function that elements must satisfy.
     * @return The current instance of the validator.
     */
    Lists<T, TO> satisfies(Predicate<T> predicate);
}