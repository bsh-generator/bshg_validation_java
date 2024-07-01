package org.bshg.validation.exceptions;

import org.bshg.validation.ValidateResult;

import java.util.List;

public class ValidatorException extends RuntimeException {
    private final int status = 400;
    private final List<ValidateResult<?>> results;

    public ValidatorException(List<ValidateResult<?>> results) {
        this.results = results;
    }

    public int getStatus() {
        return status;
    }

    public List<ValidateResult<?>> getResults() {
        return results;
    }
}
