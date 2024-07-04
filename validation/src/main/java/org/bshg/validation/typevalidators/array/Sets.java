package org.bshg.validation.typevalidators.array;

import org.bshg.validation.typevalidators.TypeValidator;

import java.util.Set;
import java.util.function.Predicate;

/**
 * Interface defining validation methods for Set values.
 *
 * @param <T> The type of elements in the Set.
 * @param <TO> The type of object to validate.
 */
public interface Sets<T, TO> extends TypeValidator<Set<T>, TO, Sets<T, TO>> {

    /**
     * Specifies that the Set must not be null or empty.
     *
     * @return The current instance of the validator.
     */
    Sets<T, TO> required();

    /**
     * Specifies the minimum size required for the Set.
     *
     * @param min Minimum size allowed.
     * @return The current instance of the validator.
     */
    Sets<T, TO> minSize(int min);

    /**
     * Specifies the maximum size allowed for the Set.
     *
     * @param max Maximum size allowed.
     * @return The current instance of the validator.
     */
    Sets<T, TO> maxSize(int max);

    /**
     * Specifies a range of allowed sizes (inclusive) for the Set.
     *
     * @param min Minimum size allowed.
     * @param max Maximum size allowed.
     * @return The current instance of the validator.
     */
    Sets<T, TO> sizeBetween(int min, int max);

    /**
     * Specifies that the Set must contain a specific element.
     *
     * @param element Element that must be present in the Set.
     * @return The current instance of the validator.
     */
    Sets<T, TO> contains(T element);

    /**
     * Specifies that all elements in the Set must satisfy a given predicate.
     *
     * @param predicate Predicate function that elements must satisfy.
     * @return The current instance of the validator.
     */
    Sets<T, TO> satisfies(Predicate<T> predicate);
}