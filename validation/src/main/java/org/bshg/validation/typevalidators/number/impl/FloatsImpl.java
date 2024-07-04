package org.bshg.validation.typevalidators.number.impl;

import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.number.Floats;
import org.bshg.validation.utils.local.LocalUtils;
import org.bshg.validation.utils.local.errors.NumbersErrors;

import java.util.Objects;

public class FloatsImpl<TO> extends TypeValidatorImpl<Float, TO, Floats<TO>> implements Floats<TO> {
    protected NumbersErrors errors() {
        return LocalUtils.local().messages().number();
    }

    @Override
    public Floats<TO> required() {
        return onError(Objects::isNull, errors().required());
    }

    @Override
    public Floats<TO> min(Float minValue) {
        return onError(value -> value < minValue, errors().min(), new Object[]{minValue});
    }

    @Override
    public Floats<TO> max(Float maxValue) {
        return onError(value -> value > maxValue, errors().max(), new Object[]{maxValue});
    }

    @Override
    public Floats<TO> range(Float minValue, Float maxValue) {
        return onError(value -> value < minValue || value > maxValue, errors().range(), new Object[]{minValue, maxValue});
    }

    @Override
    public Floats<TO> positive() {
        return onError(value -> value < 0, errors().positive());
    }

    @Override
    public Floats<TO> negative() {
        return onError(value -> value > 0, errors().negative());
    }

    @Override
    public Floats<TO> multipleOf(Float divisor) {
        return onError(value -> value % divisor != 0, errors().multipleOf(), new Object[]{divisor});
    }

    @Override
    public Floats<TO> betweenExclusive(Float minValue, Float maxValue) {
        return onError(value -> value <= minValue || value >= maxValue, errors().betweenExclusive(), new Object[]{minValue, maxValue});
    }

    @Override
    public Floats<TO> even() {
        return onError(value -> value % 2 != 0, errors().even());
    }

    @Override
    public Floats<TO> odd() {
        return onError(value -> value % 2 == 0, errors().odd());
    }

    @Override
    public Floats<TO> divisibleBy(Float divisor) {
        return onError(value -> value % divisor != 0, errors().divisibleBy(), new Object[]{divisor});
    }
}