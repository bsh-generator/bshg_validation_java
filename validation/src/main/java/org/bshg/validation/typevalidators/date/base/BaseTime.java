package org.bshg.validation.typevalidators.date.base;

/**
 * Interface defining validation methods for time-like values, inheriting from {@link BaseDateType}.
 *
 * @param <TTime>          The type of time value to validate (e.g., java.time.LocalTime, java.util.Date).
 * @param <TObject>        The type of object to validate.
 * @param <TTypeValidator> The type of the implementing validator.
 */
public interface BaseTime<TTime, TObject, TTypeValidator extends BaseTime<TTime, TObject, TTypeValidator>>
        extends BaseDateType<TTime, TObject, TTypeValidator> {
}