package org.bshg.validation.typevalidators.date.base;

import org.bshg.validation.typevalidators.TypeValidator;

/**
 * Interface defining basic validation methods for date-like values.
 *
 * @param <TDate>         The type of date value to validate (e.g., java.util.Date, java.time.LocalDate).
 * @param <TObject>       The type of object to validate.
 * @param <TTypeValidator> The type of the implementing validator.
 */
interface BaseDateType<TDate, TObject, TTypeValidator extends BaseDateType<TDate, TObject, TTypeValidator>>
        extends TypeValidator<TDate, TObject, TTypeValidator> {

    /**
     * Specifies that the date value is required (non-null).
     *
     * @return The current instance of the validator.
     */
    TTypeValidator required();

    /**
     * Specifies that the date value must be equal to the given date.
     *
     * @param date The date to compare against.
     * @return The current instance of the validator.
     */
    TTypeValidator equal(TDate date);

    /**
     * Specifies that the date value must be after the given date.
     *
     * @param date The date to compare against.
     * @return The current instance of the validator.
     */
    TTypeValidator after(TDate date);

    /**
     * Specifies that the date value must be before the given date.
     *
     * @param date The date to compare against.
     * @return The current instance of the validator.
     */
    TTypeValidator before(TDate date);

    /**
     * Specifies that the date value must be between the given start and end dates (inclusive).
     *
     * @param start The start date of the range.
     * @param end   The end date of the range.
     * @return The current instance of the validator.
     */
    TTypeValidator between(TDate start, TDate end);

    /**
     * Specifies that the date value must be in the past (before the current date).
     *
     * @return The current instance of the validator.
     */
    TTypeValidator past();

    /**
     * Specifies that the date value must be in the future (after the current date).
     *
     * @return The current instance of the validator.
     */
    TTypeValidator future();
}