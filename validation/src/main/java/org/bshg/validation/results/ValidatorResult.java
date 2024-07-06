package org.bshg.validation.results;

import java.util.ArrayList;
import java.util.List;

public record ValidatorResult(
        List<TypeValidateResult<?>> simple
) {
    public ValidatorResult() {
        this(new ArrayList<>());
    }

    public boolean errorFound() {
        return this.simple.stream().anyMatch(TypeValidateResult::isNotValid);
    }
}