package org.bshg.validation.typevalidators.bool;

import org.bshg.validation.typevalidators.TypeValidatorImpl;

import java.util.Objects;

public class BooleansImpl<TO> extends TypeValidatorImpl<Boolean, TO, Booleans<TO>> implements Booleans<TO> {
    @Override
    public Booleans<TO> required() {
        return onError(Objects::isNull, "This field is required");
    }

    @Override
    public Booleans<TO> trueValue() {
        return onError(value -> value == null || !value, "Value must be true");
    }

    @Override
    public Booleans<TO> falseValue() {
        return onError(value -> value == null || value, "Value must be false");
    }

    @Override
    public Booleans<TO> isEqualTo(Boolean compareValue) {
        return onError(value -> !value.equals(compareValue), "Value must be equal to " + compareValue);
    }
}