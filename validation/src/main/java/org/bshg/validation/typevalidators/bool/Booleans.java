package org.bshg.validation.typevalidators.bool;

import org.bshg.validation.typevalidators.TypeValidator;

/**
 * Interface defining validation methods for Boolean values.
 *
 * @param <TO> The type of object to validate.
 */
public interface Booleans<TO> extends TypeValidator<Boolean, TO, Booleans<TO>> {

    /**
     * Specifies that the Boolean value is required (non-null).
     *
     * @return The current instance of the validator.
     */
    Booleans<TO> required();

    /**
     * Specifies that the Boolean value must be true.
     *
     * @return The current instance of the validator.
     */
    Booleans<TO> trueValue();

    /**
     * Specifies that the Boolean value must be false.
     *
     * @return The current instance of the validator.
     */
    Booleans<TO> falseValue();

    /**
     * Specifies that the Boolean value must be equal to a specified value.
     *
     * @param compareValue The value to compare against.
     * @return The current instance of the validator.
     */
    Booleans<TO> isEqualTo(Boolean compareValue);
}