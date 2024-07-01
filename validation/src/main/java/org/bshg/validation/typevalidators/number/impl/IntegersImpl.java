package org.bshg.validation.typevalidators.number.impl;

import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.number.Integers;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class IntegersImpl<TO> extends TypeValidatorImpl<Integer, TO> implements Integers<TO> {
    @Override
    public Integers<TO> onError(Function<Integer, Boolean> error, String message) {
        super.onError(error, message);
        return this;
    }

    @Override
    public Integers<TO> onError(Function<Integer, Boolean> error, Supplier<String> message) {
        super.onError(error, message);
        return this;
    }

    @Override
    public Integers<TO> onError(BiFunction<Integer, TO, Boolean> error, String message) {
        super.onError(error, message);
        return this;
    }

    @Override
    public Integers<TO> onError(BiFunction<Integer, TO, Boolean> error, Supplier<String> message) {
        super.onError(error, message);
        return this;
    }
    ////////////////////

    @Override
    public Integers<TO> required() {
        return onError(Objects::isNull, "This field is required!");
    }

    @Override
    public Integers<TO> min(Integer minValue) {
        return onError(value -> value < minValue, "min allowed value is " + minValue);
    }

    @Override
    public Integers<TO> max(Integer maxValue) {
        return onError(value -> value > maxValue, "max allowed value is " + maxValue);
    }

    @Override
    public Integers<TO> range(Integer minValue, Integer maxValue) {
        return onError(value -> value < minValue || value > maxValue, "Value must be between " + minValue + " and " + maxValue);
    }

    @Override
    public Integers<TO> positive() {
        return onError(value -> value < 0, "Value must be positive");
    }

    @Override
    public Integers<TO> negative() {
        return onError(value -> value > 0, "Value must be negative");
    }

    @Override
    public Integers<TO> multipleOf(Integer divisor) {
        return onError(value -> value % divisor != 0, "Value must be a multiple of " + divisor);
    }

    @Override
    public Integers<TO> betweenExclusive(Integer minValue, Integer maxValue) {
        return onError(value -> value <= minValue || value >= maxValue, "Value must be between " + minValue + " (exclusive) and " + maxValue + " (exclusive)");
    }

    @Override
    public Integers<TO> even() {
        return onError(value -> value % 2 != 0, "Value must be an even number");
    }

    @Override
    public Integers<TO> odd() {
        return onError(value -> value % 2 == 0, "Value must be an odd number");
    }

    @Override
    public Integers<TO> divisibleBy(Integer divisor) {
        return onError(value -> value % divisor != 0, "Value must be divisible by " + divisor);
    }

    @Override
    public Integers<TO> perfectSquare() {
        return onError(value -> Math.sqrt(value) != Math.abs(Math.sqrt(value)), "Value must be a perfect square");
    }

    @Override
    public Integers<TO> primeNumber() {
        return onError(value -> {
            if (value < 2) return true;
            for (var i = 2; i <= Math.sqrt(value); i++) {
                if (value % i == 0) return true;
            }
            return false;
        }, "Value must be a prime number");
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
        }, "Value must be a Fibonacci number");
    }

    @Override
    public Integers<TO> powerOfTwo() {
        return onError(value -> (value & (value - 1)) != 0, "Value must be a power of two");
    }
}
