package org.bshg.validation.typevalidators.date.base;

/**
 * Extended interface defining additional validation methods for date-like values,
 * inheriting from {@link BaseDateType}.
 *
 * @param <TDate>         The type of date value to validate (e.g., java.util.Date, java.time.LocalDate).
 * @param <TObject>       The type of object to validate.
 * @param <TTypeValidator> The type of the implementing validator.
 */
interface BaseDateType2<TDate, TObject, TTypeValidator extends BaseDateType2<TDate, TObject, TTypeValidator>>
        extends BaseDateType<TDate, TObject, TTypeValidator> {

    /**
     * Specifies that the date value must be today or later.
     *
     * @return The current instance of the validator.
     */
    TTypeValidator todayOrAfter();

    /**
     * Specifies that the date value must be today or earlier.
     *
     * @return The current instance of the validator.
     */
    TTypeValidator todayOrBefore();

    /**
     * Specifies that the date value must be a weekday (Monday to Friday).
     *
     * @return The current instance of the validator.
     */
    TTypeValidator weekday();

    /**
     * Specifies that the date value must be a weekend day (Saturday or Sunday).
     *
     * @return The current instance of the validator.
     */
    TTypeValidator weekend();

    /**
     * Specifies that the date value must occur in a leap year.
     *
     * @return The current instance of the validator.
     */
    TTypeValidator leapYear();
}