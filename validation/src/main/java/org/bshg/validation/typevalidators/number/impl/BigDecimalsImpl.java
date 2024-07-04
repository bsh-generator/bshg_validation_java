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

    @Override
    public BigDecimals<TO> perfectSquare() {
        return onError(value -> {
            BigDecimal sqrt = BigDecimal.valueOf(Math.sqrt(value.doubleValue()));
            return sqrt.setScale(0, RoundingMode.HALF_UP).pow(2).compareTo(value) != 0;
        }, errors().perfectSquare());
    }

    @Override
    public BigDecimals<TO> primeNumber() {
        return onError(value -> {
            if (value.compareTo(BigDecimal.ONE) <= 0) return true;
            if (value.compareTo(new BigDecimal(2)) == 0) return false;
            if (value.remainder(new BigDecimal(2)).equals(BigDecimal.ZERO)) return true;

            BigDecimal sqrt = BigDecimal.valueOf(Math.sqrt(value.doubleValue())).setScale(0, RoundingMode.HALF_UP);
            for (BigDecimal i = new BigDecimal(3); i.compareTo(sqrt) <= 0; i = i.add(new BigDecimal(2))) {
                if (value.remainder(i).equals(BigDecimal.ZERO)) return true;
            }
            return false;
        }, errors().primeNumber());
    }

    @Override
    public BigDecimals<TO> fibonacciNumber() {
        return onError(value -> {
            if (value.compareTo(BigDecimal.ZERO) < 0) return true;
            BigDecimal a = BigDecimal.ZERO;
            BigDecimal b = BigDecimal.ONE;
            while (b.compareTo(value) < 0) {
                BigDecimal temp = b;
                b = b.add(a);
                a = temp;
            }
            return b.compareTo(value) != 0;
        }, errors().fibonacciNumber());
    }
}