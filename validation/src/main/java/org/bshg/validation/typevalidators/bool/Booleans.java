package org.bshg.validation.typevalidators.bool;

import org.bshg.validation.typevalidators.TypeValidator;

public interface Booleans<TO> extends TypeValidator<Boolean, TO, Booleans<TO>> {
    Booleans<TO> required();

    Booleans<TO> trueValue();

    Booleans<TO> falseValue();

    Booleans<TO> isEqualTo(Boolean compareValue);
}