package org.bshg.validation.typevalidators.number.impl;

import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.number.BigDecimals;
import org.bshg.validation.utils.local.LocalUtils;
import org.bshg.validation.utils.local.errors.NumbersErrors;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class BigDecimalsImpl<TO> extends TypeValidatorImpl<BigDecimal, TO, BigDecimals<TO>> implements BigDecimals<TO> {

    protected NumbersErrors errors() {
        return LocalUtils.local().messages().number();
    }

    @Override
    public BigDecimals<TO> required() {
        return onError(Objects::isNull, errors().required());
    }

    @Override
    public BigDecimals<TO> min(BigDecimal minValue) {
        return onError(value -> value.compareTo(minValue) < 0, errors().min(), new Object[]{minValue});
    }

    @Override
    public BigDecimals<TO> max(BigDecimal maxValue) {
        return onError(value -> value.compareTo(maxValue) > 0, errors().max(), new Object[]{maxValue});
    }

    @Override
    public BigDecimals<TO> range(BigDecimal minValue, BigDecimal maxValue) {
        return onError(value -> value.compareTo(minValue) < 0 || value.compareTo(maxValue) > 0, errors().range(), new Object[]{minValue, maxValue});
    }

    @Override
    public BigDecimals<TO> positive() {
        return onError(value -> value.compareTo(BigDecimal.ZERO) <= 0, errors().positive());
    }

    @Override
    public BigDecimals<TO> negative() {
        return onError(value -> value.compareTo(BigDecimal.ZERO) >= 0, errors().negative());
    }

    @Override
    public BigDecimals<TO> multipleOf(BigDecimal divisor) {
        return onError(value -> value.remainder(divisor).compareTo(BigDecimal.ZERO) != 0, errors().multipleOf(), new Object[]{divisor});
    }

    @Override
    public BigDecimals<TO> betweenExclusive(BigDecimal minValue, BigDecimal maxValue) {
        return onError(value -> value.compareTo(minValue) <= 0 || value.compareTo(maxValue) >= 0, errors().betweenExclusive(), new Object[]{minValue, maxValue});
    }

    @Override
    public BigDecimals<TO> even() {
        return onError(value -> !value.remainder(new BigDecimal(2)).equals(BigDecimal.ZERO), errors().even());
    }

    @Override
    public BigDecimals<TO> odd() {
        return onError(value -> value.remainder(new BigDecimal(2)).equals(BigDecimal.ZERO), errors().odd());
    }

    @Override
    public BigDecimals<TO> divisibleBy(BigDecimal divisor) {
        return onError(value -> value.remainder(divisor).compareTo(BigDecimal.ZERO) != 0, errors().divisibleBy(), new Object[]{divisor});
    }
}