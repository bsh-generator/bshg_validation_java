package org.bshg.validation.typevalidators.date.base;

/**
 * Extended interface inheriting from {@link BaseDateType2}, defining additional validation methods
 * for date-like values.
 *
 * @param <TDate>         The type of date value to validate (e.g., java.util.Date, java.time.LocalDate).
 * @param <TObject>       The type of object to validate.
 * @param <TTypeValidator> The type of the implementing validator.
 */
public interface BaseDate<TDate, TObject, TTypeValidator extends BaseDate<TDate, TObject, TTypeValidator>>
        extends BaseDateType2<TDate, TObject, TTypeValidator> {
}