package org.bshg.validation.typevalidators.number.impl;

import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.number.Doubles;
import org.bshg.validation.utils.local.LocalUtils;
import org.bshg.validation.utils.local.errors.NumbersErrors;

import java.util.Objects;

public class DoublesImpl<TO> extends TypeValidatorImpl<Double, TO, Doubles<TO>> implements Doubles<TO> {
    protected NumbersErrors errors() {
        return LocalUtils.local().messages().number();
    }

    @Override
    public Doubles<TO> required() {
        return onError(Objects::isNull, errors().required());
    }

    @Override
    public Doubles<TO> min(Double minValue) {
        return onError(value -> value < minValue, errors().min(), new Object[]{minValue});
    }

    @Override
    public Doubles<TO> max(Double maxValue) {
        return onError(value -> value > maxValue, errors().max(), new Object[]{maxValue});
    }

    @Override
    public Doubles<TO> range(Double minValue, Double maxValue) {
        return onError(value -> value < minValue || value > maxValue, errors().range(), new Object[]{minValue, maxValue});
    }

    @Override
    public Doubles<TO> positive() {
        return onError(value -> value < 0, errors().positive());
    }

    @Override
    public Doubles<TO> negative() {
        return onError(value -> value > 0, errors().negative());
    }

    @Override
    public Doubles<TO> multipleOf(Double divisor) {
        return onError(value -> value % divisor != 0, errors().multipleOf(), new Object[]{divisor});
    }

    @Override
    public Doubles<TO> betweenExclusive(Double minValue, Double maxValue) {
        return onError(value -> value <= minValue || value >= maxValue, errors().betweenExclusive(), new Object[]{minValue});
    }

    @Override
    public Doubles<TO> even() {
        return onError(value -> value % 2 != 0, errors().even());
    }

    @Override
    public Doubles<TO> odd() {
        return onError(value -> value % 2 == 0, errors().odd());
    }

    @Override
    public Doubles<TO> divisibleBy(Double divisor) {
        return onError(value -> value % divisor != 0, errors().divisibleBy(), new Object[]{divisor});
    }

    @Override
    public Doubles<TO> perfectSquare() {
        return onError(value -> Math.sqrt(value) != Math.abs(Math.sqrt(value)), errors().perfectSquare());
    }

    @Override
    public Doubles<TO> primeNumber() {
        return onError(value -> {
            if (value < 2) return true;
            for (var i = 2; i <= Math.sqrt(value); i++) {
                if (value % i == 0) return true;
            }
            return false;
        }, errors().primeNumber());
    }

    @Override
    public Doubles<TO> fibonacciNumber() {
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
}