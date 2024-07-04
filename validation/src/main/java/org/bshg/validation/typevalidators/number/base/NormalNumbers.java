package org.bshg.validation.typevalidators.number.base;

/**
 * Interface defining validation methods specifically for normal numeric values,
 * such as integers, doubles, and other numeric types.
 *
 * @param <TNumber>       The type of numeric value to validate (e.g., Integer, Double, BigDecimal).
 * @param <TObject>       The type of object to validate.
 * @param <TTypeValidator> The type of the implementing validator.
 */
public interface NormalNumbers<TNumber, TObject, TTypeValidator extends NormalNumbers<TNumber, TObject, TTypeValidator>> extends Numbers<TNumber, TObject, TTypeValidator> {

    /**
     * Specifies that the numeric value must be a power of two.
     * Example:
     * - Correct value: 8 (2^3)
     * - Incorrect value: 10
     *
     * @return The current instance of the validator.
     */
    TTypeValidator powerOfTwo();

    /**
     * Specifies that the numeric value must be a perfect square.
     * Example:
     * - Correct value: 16 (4^2)
     * - Incorrect value: 10
     *
     * @return The current instance of the validator.
     */
    TTypeValidator perfectSquare();

    /**
     * Specifies that the numeric value must be a prime number.
     * Example:
     * - Correct value: 17
     * - Incorrect value: 15
     *
     * @return The current instance of the validator.
     */
    TTypeValidator primeNumber();

    /**
     * Specifies that the numeric value must be a Fibonacci number.
     * Example:
     * - Correct value: 8 (Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8, ...)
     * - Incorrect value: 10
     *
     * @return The current instance of the validator.
     */
    TTypeValidator fibonacciNumber();
}