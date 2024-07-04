package org.bshg.validation.typevalidators.bool;

import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.utils.local.LocalUtils;
import org.bshg.validation.utils.local.errors.BooleansErrors;

import java.util.Objects;

public class BooleansImpl<TO> extends TypeValidatorImpl<Boolean, TO, Booleans<TO>> implements Booleans<TO> {
    protected BooleansErrors errors() {
        return LocalUtils.local().messages().bool();
    }

    @Override
    public Booleans<TO> required() {
        return onError(Objects::isNull, errors().required());
    }

    @Override
    public Booleans<TO> trueValue() {
        return onError(value -> value == null || !value, errors().trueValue());
    }

    @Override
    public Booleans<TO> falseValue() {
        return onError(value -> value == null || value, errors().falseValue());
    }

    @Override
    public Booleans<TO> isEqualTo(Boolean compareValue) {
        return onError(value -> !value.equals(compareValue), errors().isEqualTo(), new Object[]{compareValue});
    }
}