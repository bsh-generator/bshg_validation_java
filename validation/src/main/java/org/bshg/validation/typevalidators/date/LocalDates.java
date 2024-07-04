package org.bshg.validation.typevalidators.date;

import org.bshg.validation.typevalidators.date.base.BaseDate;

import java.time.LocalDate;

/**
 * Interface defining validation methods for java.time.LocalDate values,
 * inheriting from {@link BaseDate}.
 *
 * @param <TO> The type of object to validate.
 */
public interface LocalDates<TO> extends BaseDate<LocalDate, TO, LocalDates<TO>> {
}