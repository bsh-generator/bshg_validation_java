package org.bshg.validation.typevalidators.date;

import org.bshg.validation.typevalidators.date.base.BaseDateTime;

import java.time.LocalDateTime;

/**
 * Interface defining validation methods for java.time.LocalDateTime values,
 * inheriting from {@link BaseDateTime}.
 *
 * @param <TO> The type of object to validate.
 */
public interface LocalDateTimes<TO> extends BaseDateTime<LocalDateTime, TO, LocalDateTimes<TO>> {
}