package org.bshg.validation.typevalidators.number.impl;

import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.number.Longs;
import org.bshg.validation.utils.local.LocalUtils;
import org.bshg.validation.utils.local.errors.NumbersErrors;

import java.util.Objects;

public class LongsImpl<TO> extends TypeValidatorImpl<Long, TO, Longs<TO>> implements Longs<TO> {
    protected NumbersErrors errors() {
        return LocalUtils.local().messages().number();
    }

    @Override
    public Longs<TO> required() {
        return onError(Objects::isNull, errors().required());
    }

    @Override
    public Longs<TO> min(Long minValue) {
        return onError(value -> value < minValue, errors().min(), new Object[]{minValue});
    }

    @Override
    public Longs<TO> max(Long maxValue) {
        return onError(value -> value > maxValue, errors().max(), new Object[]{maxValue});
    }

    @Override
    public Longs<TO> range(Long minValue, Long maxValue) {
        return onError(value -> value < minValue || value > maxValue, errors().range(), new Object[]{minValue, maxValue});
    }

    @Override
    public Longs<TO> positive() {
        return onError(value -> value < 0, errors().positive());
    }

    @Override
    public Longs<TO> negative() {
        return onError(value -> value > 0, errors().negative());
    }

    @Override
    public Longs<TO> multipleOf(Long divisor) {
        return onError(value -> value % divisor != 0, errors().multipleOf(), new Object[]{divisor});
    }

    @Override
    public Longs<TO> betweenExclusive(Long minValue, Long maxValue) {
        return onError(value -> value <= minValue || value >= maxValue, errors().betweenExclusive(), new Object[]{minValue, maxValue});
    }

    @Override
    public Longs<TO> even() {
        return onError(value -> value % 2 != 0, errors().even());
    }

    @Override
    public Longs<TO> odd() {
        return onError(value -> value % 2 == 0, errors().odd());
    }

    @Override
    public Longs<TO> divisibleBy(Long divisor) {
        return onError(value -> value % divisor != 0, errors().divisibleBy(), new Object[]{divisor});
    }

    @Override
    public Longs<TO> perfectSquare() {
        return onError(value -> Math.sqrt(value) != Math.abs(Math.sqrt(value)), errors().perfectSquare());
    }

    @Override
    public Longs<TO> primeNumber() {
        return onError(value -> {
            if (value < 2) return true;
            for (var i = 2; i <= Math.sqrt(value); i++) {
                if (value % i == 0) return true;
            }
            return false;
        }, errors().primeNumber());
    }

    @Override
    public Longs<TO> fibonacciNumber() {
        return onError(value -> {
            if (value < 0) return true;
            var a = 0;
            var b = 1;
            while (b < value) {
                var temp = b;
                b += a;
                a = temp;
            }
            return b != value;
        }, errors().fibonacciNumber());
    }

    @Override
    public Longs<TO> powerOfTwo() {
        return onError(value -> (value & (value - 1)) != 0, errors().powerOfTwo());
    }
}