package org.bshg.validation.typevalidators.date;

import org.bshg.validation.typevalidators.date.base.BaseTime;

import java.time.LocalTime;

/**
 * Interface defining validation methods for java.time.LocalTime values,
 * inheriting from {@link BaseTime}.
 *
 * @param <TO> The type of object to validate.
 */
public interface LocalTimes<TO> extends BaseTime<LocalTime, TO, LocalTimes<TO>> {
}