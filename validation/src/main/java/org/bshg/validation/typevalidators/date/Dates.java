package org.bshg.validation.typevalidators.date;

import org.bshg.validation.typevalidators.date.base.BaseDate;

import java.util.Date;

/**
 * Interface defining validation methods for java.util.Date values,
 * inheriting from {@link BaseDate}.
 *
 * @param <TO> The type of object to validate.
 */
public interface Dates<TO> extends BaseDate<Date, TO, Dates<TO>> {
}