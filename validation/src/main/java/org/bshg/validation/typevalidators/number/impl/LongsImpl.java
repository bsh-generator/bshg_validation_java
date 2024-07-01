package org.bshg.validation.typevalidators.number.impl;

import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.number.Longs;

import java.util.Objects;

public class LongsImpl<TO> extends TypeValidatorImpl<Long, TO, Longs<TO>> implements Longs<TO> {
    @Override
    public Longs<TO> required() {
        return onError(Objects::isNull, "This field is required!");
    }

    @Override
    public Longs<TO> min(Long minValue) {
        return onError(value -> value < minValue, "min allowed value is " + minValue);
    }

    @Override
    public Longs<TO> max(Long maxValue) {
        return onError(value -> value > maxValue, "max allowed value is " + maxValue);
    }

    @Override
    public Longs<TO> range(Long minValue, Long maxValue) {
        return onError(value -> value < minValue || value > maxValue, "Value must be between " + minValue + " and " + maxValue);
    }

    @Override
    public Longs<TO> positive() {
        return onError(value -> value < 0, "Value must be positive");
    }

    @Override
    public Longs<TO> negative() {
        return onError(value -> value > 0, "Value must be negative");
    }

    @Override
    public Longs<TO> multipleOf(Long divisor) {
        return onError(value -> value % divisor != 0, "Value must be a multiple of " + divisor);
    }

    @Override
    public Longs<TO> betweenExclusive(Long minValue, Long maxValue) {
        return onError(value -> value <= minValue || value >= maxValue, "Value must be between " + minValue + " (exclusive) and " + maxValue + " (exclusive)");
    }

    @Override
    public Longs<TO> even() {
        return onError(value -> value % 2 != 0, "Value must be an even number");
    }

    @Override
    public Longs<TO> odd() {
        return onError(value -> value % 2 == 0, "Value must be an odd number");
    }

    @Override
    public Longs<TO> divisibleBy(Long divisor) {
        return onError(value -> value % divisor != 0, "Value must be divisible by " + divisor);
    }

    @Override
    public Longs<TO> perfectSquare() {
        return onError(value -> Math.sqrt(value) != Math.abs(Math.sqrt(value)), "Value must be a perfect square");
    }

    @Override
    public Longs<TO> primeNumber() {
        return onError(value -> {
            if (value < 2) return true;
            for (var i = 2; i <= Math.sqrt(value); i++) {
                if (value % i == 0) return true;
            }
            return false;
        }, "Value must be a prime number");
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
        }, "Value must be a Fibonacci number");
    }

    @Override
    public Longs<TO> powerOfTwo() {
        return onError(value -> (value & (value - 1)) != 0, "Value must be a power of two");
    }
}
