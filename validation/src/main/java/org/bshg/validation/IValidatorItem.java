package org.bshg.validation;

import org.bshg.validation.results.TypeValidateResult;
import org.bshg.validation.typevalidators.config.ValidatorFnConfig;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.regex.Pattern;

/**
 * ValidatorItem Interface
 *
 * @param <T> the type of the field being validated
 * @param <TO> the type of the object containing the field
 */
public interface IValidatorItem<T, TO> {

    /**
     * Sets the validation message using the provided ValidatorFnConfig.
     *
     * @param fn the ValidatorFnConfig containing the message function and arguments
     */
    default void setMessage(ValidatorFnConfig<T, TO> fn) {
        var message = fn.messageFn() != null ? fn.messageFn().get() : fn.message();
        var args = fn.args();

        // Regular expression to find %n patterns
        var pattern = Pattern.compile("%(\\d+)");
        var matcher = pattern.matcher(message);

        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            var index = Integer.parseInt(matcher.group(1)) - 1;
            var replacement = index < args.length ? Arrays.toString(args[index]) : "[null]";
            // TODO remove [...] from the result
            matcher.appendReplacement(sb, replacement);
        }
        matcher.appendTail(sb);

        this.setMessage(sb.toString());
    }

    /**
     * Sets the validation message.
     *
     * @param message the validation message
     */
    void setMessage(String message);

    /**
     * Records a validation error with the given message.
     *
     * @param msg the error message
     */
    void error(String msg);

    /**
     * Records a validation error using the provided ValidatorFnConfig.
     *
     * @param fn the ValidatorFnConfig containing the error configuration
     */
    void error(ValidatorFnConfig<T, TO> fn);

    /**
     * Returns the validation result.
     *
     * @return the validation result as a TypeValidateResult
     */
    TypeValidateResult<T> result();

    /**
     * Returns the validation result with a specified prefix.
     *
     * @param prefix the prefix to be added to the field name in the result
     * @return the validation result as a TypeValidateResult
     */
    TypeValidateResult<T> result(String prefix);

    /**
     * Checks if the validation is successful.
     *
     * @return true if the validation is successful, false otherwise
     */
    boolean isValid();

    /**
     * Checks if the validation is not successful.
     *
     * @return true if the validation is not successful, false otherwise
     */
    default boolean isNotValid() {
        return !isValid();
    }

    /**
     * Marks the validation as successful.
     */
    void markAsValid();

    /**
     * Gets the field being validated.
     *
     * @return the field being validated as a Supplier
     */
    Supplier<T> getField();

    /**
     * Performs validation on the given object.
     *
     * @param object the object containing the field to be validated
     */
    void validate(TO object);
}
