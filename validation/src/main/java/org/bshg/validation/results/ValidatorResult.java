package org.bshg.validation.results;

import java.util.ArrayList;
import java.util.List;

public record ValidatorResult(List<TypeValidateResult<?>> items) {
    public ValidatorResult() {
        this(new ArrayList<>());
    }

    public boolean errorFound() {
        return this.items.stream().anyMatch(TypeValidateResult::isNotValid);
    }
}