package org.bshg.validation.typevalidators.number.impl;

import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.number.Floats;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class FloatsImpl<TO> extends TypeValidatorImpl<Float, TO> implements Floats<TO> {
    @Override
    public Floats<TO> onError(Function<Float, Boolean> error, String message) {
        super.onError(error, message);
        return this;
    }

    @Override
    public Floats<TO> onError(Function<Float, Boolean> error, Supplier<String> message) {
        super.onError(error, message);
        return this;
    }

    @Override
    public Floats<TO> onError(BiFunction<Float, TO, Boolean> error, String message) {
        super.onError(error, message);
        return this;
    }

    @Override
    public Floats<TO> onError(BiFunction<Float, TO, Boolean> error, Supplier<String> message) {
        super.onError(error, message);
        return this;
    }
    ////////////////////

    @Override
    public Floats<TO> required() {
        return onError(Objects::isNull, "This field is required!");
    }

    @Override
    public Floats<TO> min(Float minValue) {
        return onError(value -> value < minValue, "min allowed value is " + minValue);
    }

    @Override
    public Floats<TO> max(Float maxValue) {
        return onError(value -> value > maxValue, "max allowed value is " + maxValue);
    }

    @Override
    public Floats<TO> range(Float minValue, Float maxValue) {
        return onError(value -> value < minValue || value > maxValue, "Value must be between " + minValue + " and " + maxValue);
    }

    @Override
    public Floats<TO> positive() {
        return onError(value -> value < 0, "Value must be positive");
    }

    @Override
    public Floats<TO> negative() {
        return onError(value -> value > 0, "Value must be negative");
    }

    @Override
    public Floats<TO> multipleOf(Float divisor) {
        return onError(value -> value % divisor != 0, "Value must be a multiple of " + divisor);
    }

    @Override
    public Floats<TO> betweenExclusive(Float minValue, Float maxValue) {
        return onError(value -> value <= minValue || value >= maxValue, "Value must be between " + minValue + " (exclusive) and " + maxValue + " (exclusive)");
    }

    @Override
    public Floats<TO> even() {
        return onError(value -> value % 2 != 0, "Value must be an even number");
    }

    @Override
    public Floats<TO> odd() {
        return onError(value -> value % 2 == 0, "Value must be an odd number");
    }

    @Override
    public Floats<TO> divisibleBy(Float divisor) {
        return onError(value -> value % divisor != 0, "Value must be divisible by " + divisor);
    }

    @Override
    public Floats<TO> perfectSquare() {
        return onError(value -> Math.sqrt(value) != Math.abs(Math.sqrt(value)), "Value must be a perfect square");
    }

    @Override
    public Floats<TO> primeNumber() {
        return onError(value -> {
            if (value < 2) return true;
            for (var i = 2; i <= Math.sqrt(value); i++) {
                if (value % i == 0) return true;
            }
            return false;
        }, "Value must be a prime number");
    }

    @Override
    public Floats<TO> fibonacciNumber() {
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
}
