package org.bshg.validation.utils.local.errors;

public record BooleansErrors(
        String required,
        String trueValue,
        String falseValue,
        String isEqualTo
) {
}