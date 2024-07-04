package org.bshg.validation.typevalidators.date.base;

/**
 * Extended interface inheriting from {@link BaseDateType2}, defining additional validation methods
 * for date-time-like values.
 *
 * @param <TDateTime>      The type of date-time value to validate (e.g., java.util.Date, java.time.LocalDateTime).
 * @param <TObject>        The type of object to validate.
 * @param <TTypeValidator> The type of the implementing validator.
 */
public interface BaseDateTime<TDateTime, TObject, TTypeValidator extends BaseDateTime<TDateTime, TObject, TTypeValidator>>
        extends BaseDateType2<TDateTime, TObject, TTypeValidator> {
}