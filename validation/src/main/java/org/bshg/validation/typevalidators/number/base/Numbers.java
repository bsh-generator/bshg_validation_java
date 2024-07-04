package org.bshg.validation.typevalidators.number.base;

import org.bshg.validation.typevalidators.TypeValidator;

/**
 * Interface defining validation methods for numeric types.
 *
 * @param <TNumber>      The type of numeric value to validate (e.g., Integer, Double, BigDecimal).
 * @param <TObject>      The type of object to validate.
 * @param <TTypeValidator> The type of the implementing validator.
 */
public interface Numbers<TNumber, TObject, TTypeValidator extends Numbers<TNumber, TObject, TTypeValidator>>
        extends TypeValidator<TNumber, TObject, TTypeValidator> {
    /**
     * Specifies that the numeric value is required (non-null or non-zero).
     *
     * @return The current instance of the validator.
     */
    TTypeValidator required();

    /**
     * Specifies the minimum allowed value for the numeric value.
     *
     * @param minValue Minimum allowed value.
     * @return The current instance of the validator.
     */
    TTypeValidator min(TNumber minValue);

    /**
     * Specifies the maximum allowed value for the numeric value.
     *
     * @param maxValue Maximum allowed value.
     * @return The current instance of the validator.
     */
    TTypeValidator max(TNumber maxValue);

    /**
     * Specifies the range of allowed values for the numeric value (inclusive).
     *
     * @param minValue Minimum allowed value.
     * @param maxValue Maximum allowed value.
     * @return The current instance of the validator.
     */
    TTypeValidator range(TNumber minValue, TNumber maxValue);

    /**
     * Specifies that the numeric value must be positive.
     *
     * @return The current instance of the validator.
     */
    TTypeValidator positive();

    /**
     * Specifies that the numeric value must be negative.
     *
     * @return The current instance of the validator.
     */
    TTypeValidator negative();

    /**
     * Specifies that the numeric value must be a multiple of the given divisor.
     *
     * @param divisor Divisor value.
     * @return The current instance of the validator.
     */
    TTypeValidator multipleOf(TNumber divisor);

    /**
     * Specifies a range of allowed values for the numeric value (exclusive).
     *
     * @param minValue Minimum allowed value (exclusive).
     * @param maxValue Maximum allowed value (exclusive).
     * @return The current instance of the validator.
     */
    TTypeValidator betweenExclusive(TNumber minValue, TNumber maxValue);

    /**
     * Specifies that the numeric value must be even.
     *
     * @return The current instance of the validator.
     */
    TTypeValidator even();

    /**
     * Specifies that the numeric value must be odd.
     *
     * @return The current instance of the validator.
     */
    TTypeValidator odd();

    /**
     * Specifies that the numeric value must be divisible by the given divisor.
     *
     * @param divisor Divisor value.
     * @return The current instance of the validator.
     */
    TTypeValidator divisibleBy(TNumber divisor);
}