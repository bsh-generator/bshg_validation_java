package org.bshg.validation.typevalidators.number.impl;

import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.number.BigDecimals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class BigDecimalsImpl<TO> extends TypeValidatorImpl<BigDecimal, TO, BigDecimals<TO>> implements BigDecimals<TO> {
    @Override
    public BigDecimals<TO> onError(Function<BigDecimal, Boolean> error, String message) {
        super.onError(error, message);
        return this;
    }

    @Override
    public BigDecimals<TO> onError(Function<BigDecimal, Boolean> error, Supplier<String> message) {
        super.onError(error, message);
        return this;
    }

    @Override
    public BigDecimals<TO> onError(BiFunction<BigDecimal, TO, Boolean> error, String message) {
        super.onError(error, message);
        return this;
    }

    @Override
    public BigDecimals<TO> onError(BiFunction<BigDecimal, TO, Boolean> error, Supplier<String> message) {
        super.onError(error, message);
        return this;
    }

    @Override
    public BigDecimals<TO> required() {
        return onError(Objects::isNull, "This field is required!");
    }

    @Override
    public BigDecimals<TO> min(BigDecimal minValue) {
        return onError(value -> value.compareTo(minValue) < 0, "Minimum allowed value is " + minValue);
    }

    @Override
    public BigDecimals<TO> max(BigDecimal maxValue) {
        return onError(value -> value.compareTo(maxValue) > 0, "Maximum allowed value is " + maxValue);
    }

    @Override
    public BigDecimals<TO> range(BigDecimal minValue, BigDecimal maxValue) {
        return onError(value -> value.compareTo(minValue) < 0 || value.compareTo(maxValue) > 0, "Value must be between " + minValue + " and " + maxValue);
    }

    @Override
    public BigDecimals<TO> positive() {
        return onError(value -> value.compareTo(BigDecimal.ZERO) <= 0, "Value must be positive");
    }

    @Override
    public BigDecimals<TO> negative() {
        return onError(value -> value.compareTo(BigDecimal.ZERO) >= 0, "Value must be negative");
    }

    @Override
    public BigDecimals<TO> multipleOf(BigDecimal divisor) {
        return onError(value -> value.remainder(divisor).compareTo(BigDecimal.ZERO) != 0, "Value must be a multiple of " + divisor);
    }

    @Override
    public BigDecimals<TO> betweenExclusive(BigDecimal minValue, BigDecimal maxValue) {
        return onError(value -> value.compareTo(minValue) <= 0 || value.compareTo(maxValue) >= 0, "Value must be between " + minValue + " (exclusive) and " + maxValue + " (exclusive)");
    }

    @Override
    public BigDecimals<TO> even() {
        return onError(value -> !value.remainder(new BigDecimal(2)).equals(BigDecimal.ZERO), "Value must be an even number");
    }

    @Override
    public BigDecimals<TO> odd() {
        return onError(value -> value.remainder(new BigDecimal(2)).equals(BigDecimal.ZERO), "Value must be an odd number");
    }

    @Override
    public BigDecimals<TO> divisibleBy(BigDecimal divisor) {
        return onError(value -> value.remainder(divisor).compareTo(BigDecimal.ZERO) != 0, "Value must be divisible by " + divisor);
    }

    @Override
    public BigDecimals<TO> perfectSquare() {
        return onError(value -> {
            BigDecimal sqrt = BigDecimal.valueOf(Math.sqrt(value.doubleValue()));
            return sqrt.setScale(0, RoundingMode.HALF_UP).pow(2).compareTo(value) != 0;
        }, "Value must be a perfect square");
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
        }, "Value must be a prime number");
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
        }, "Value must be a Fibonacci number");
    }
}
