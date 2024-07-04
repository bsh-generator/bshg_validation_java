package org.bshg.validation.typevalidators.number;

import org.bshg.validation.typevalidators.number.base.Numbers;

import java.math.BigDecimal;

/**
 * Interface defining validation methods specifically for {@code BigDecimal} values.
 *
 * @param <TO> The type of object to validate.
 */
public interface BigDecimals<TO> extends Numbers<BigDecimal, TO, BigDecimals<TO>> {
}