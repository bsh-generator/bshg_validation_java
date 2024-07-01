package org.bshg.validation.typevalidators.number.impl;

import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.number.Doubles;

import java.util.Objects;

public class DoublesImpl<TO> extends TypeValidatorImpl<Double, TO, Doubles<TO>> implements Doubles<TO> {
    @Override
    public Doubles<TO> required() {
        return onError(Objects::isNull, "This field is required!");
    }

    @Override
    public Doubles<TO> min(Double minValue) {
        return onError(value -> value < minValue, "min allowed value is " + minValue);
    }

    @Override
    public Doubles<TO> max(Double maxValue) {
        return onError(value -> value > maxValue, "max allowed value is " + maxValue);
    }

    @Override
    public Doubles<TO> range(Double minValue, Double maxValue) {
        return onError(value -> value < minValue || value > maxValue, "Value must be between " + minValue + " and " + maxValue);
    }

    @Override
    public Doubles<TO> positive() {
        return onError(value -> value < 0, "Value must be positive");
    }

    @Override
    public Doubles<TO> negative() {
        return onError(value -> value > 0, "Value must be negative");
    }

    @Override
    public Doubles<TO> multipleOf(Double divisor) {
        return onError(value -> value % divisor != 0, "Value must be a multiple of " + divisor);
    }

    @Override
    public Doubles<TO> betweenExclusive(Double minValue, Double maxValue) {
        return onError(value -> value <= minValue || value >= maxValue, "Value must be between " + minValue + " (exclusive) and " + maxValue + " (exclusive)");
    }

    @Override
    public Doubles<TO> even() {
        return onError(value -> value % 2 != 0, "Value must be an even number");
    }

    @Override
    public Doubles<TO> odd() {
        return onError(value -> value % 2 == 0, "Value must be an odd number");
    }

    @Override
    public Doubles<TO> divisibleBy(Double divisor) {
        return onError(value -> value % divisor != 0, "Value must be divisible by " + divisor);
    }

    @Override
    public Doubles<TO> perfectSquare() {
        return onError(value -> Math.sqrt(value) != Math.abs(Math.sqrt(value)), "Value must be a perfect square");
    }

    @Override
    public Doubles<TO> primeNumber() {
        return onError(value -> {
            if (value < 2) return true;
            for (var i = 2; i <= Math.sqrt(value); i++) {
                if (value % i == 0) return true;
            }
            return false;
        }, "Value must be a prime number");
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
        }, "Value must be a Fibonacci number");
    }
}
