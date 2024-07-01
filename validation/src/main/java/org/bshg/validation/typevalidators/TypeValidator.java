package org.bshg.validation.typevalidators;

import org.bshg.validation.typevalidators.config.ValidatorFnConfig;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public interface TypeValidator<T, TO, TTypeValidator extends TypeValidator<T, TO, TTypeValidator>> {
    List<ValidatorFnConfig<T, TO>> getValidations();

    /**
     * Specifies an error condition and corresponding error message if validation fails.
     *
     * @param error   Function that defines the error condition based on the numeric value.
     * @param message Error message to be used if the validation fails.
     * @return The current instance of the validator.
     */
    TTypeValidator onError(Function<T, Boolean> error, String message);

    /**
     * Specifies an error condition and a supplier for the error message if validation fails.
     *
     * @param error   Function that defines the error condition based on the numeric value.
     * @param message Supplier that provides the error message to be used if the validation fails.
     * @return The current instance of the validator.
     */
    TTypeValidator onError(Function<T, Boolean> error, Supplier<String> message);

    /**
     * Specifies an error condition and corresponding error message if validation fails.
     *
     * @param error   BiFunction that defines the error condition based on the numeric value and the object being validated.
     * @param message Error message to be used if the validation fails.
     * @return The current instance of the validator.
     */
    TTypeValidator onError(BiFunction<T, TO, Boolean> error, String message);

    /**
     * Specifies an error condition and a supplier for the error message if validation fails.
     *
     * @param error   BiFunction that defines the error condition based on the numeric value and the object being validated.
     * @param message Supplier that provides the error message to be used if the validation fails.
     * @return The current instance of the validator.
     */
    TTypeValidator onError(BiFunction<T, TO, Boolean> error, Supplier<String> message);
}
