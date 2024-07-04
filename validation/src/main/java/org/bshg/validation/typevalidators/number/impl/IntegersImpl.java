package org.bshg.validation.typevalidators.number.impl;

import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.number.Integers;
import org.bshg.validation.utils.local.LocalUtils;
import org.bshg.validation.utils.local.errors.NumbersErrors;

import java.util.Objects;

public class IntegersImpl<TO> extends TypeValidatorImpl<Integer, TO, Integers<TO>> implements Integers<TO> {
    protected NumbersErrors errors() {
        return LocalUtils.local().messages().number();
    }

    @Override
    public Integers<TO> required() {
        return onError(Objects::isNull, errors().required());
    }

    @Override
    public Integers<TO> min(Integer minValue) {
        return onError(value -> value < minValue, errors().min(), new Object[]{minValue});
    }

    @Override
    public Integers<TO> max(Integer maxValue) {
        return onError(value -> value > maxValue, errors().max(), new Object[]{maxValue});
    }

    @Override
    public Integers<TO> range(Integer minValue, Integer maxValue) {
        return onError(value -> value < minValue || value > maxValue, errors().range(), new Object[]{minValue, maxValue});
    }

    @Override
    public Integers<TO> positive() {
        return onError(value -> value < 0, errors().positive());
    }

    @Override
    public Integers<TO> negative() {
        return onError(value -> value > 0, errors().negative());
    }

    @Override
    public Integers<TO> multipleOf(Integer divisor) {
        return onError(value -> value % divisor != 0, errors().multipleOf(), new Object[]{divisor});
    }

    @Override
    public Integers<TO> betweenExclusive(Integer minValue, Integer maxValue) {
        return onError(value -> value <= minValue || value >= maxValue, errors().betweenExclusive(), new Object[]{minValue, maxValue});
    }

    @Override
    public Integers<TO> even() {
        return onError(value -> value % 2 != 0, errors().even());
    }

    @Override
    public Integers<TO> odd() {
        return onError(value -> value % 2 == 0, errors().odd());
    }

    @Override
    public Integers<TO> divisibleBy(Integer divisor) {
        return onError(value -> value % divisor != 0, errors().min(), new Object[]{divisor});
    }

    @Override
    public Integers<TO> perfectSquare() {
        return onError(value -> Math.sqrt(value) != Math.abs(Math.sqrt(value)), errors().perfectSquare());
    }

    @Override
    public Integers<TO> primeNumber() {
        return onError(value -> {
            if (value < 2) return true;
            for (var i = 2; i <= Math.sqrt(value); i++) {
                if (value % i == 0) return true;
            }
            return false;
        }, errors().primeNumber());
    }

    @Override
    public Integers<TO> fibonacciNumber() {
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
    public Integers<TO> powerOfTwo() {
        return onError(value -> (value & (value - 1)) != 0, errors().powerOfTwo());
    }
}