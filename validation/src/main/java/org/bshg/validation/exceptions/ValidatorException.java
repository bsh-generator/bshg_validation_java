package org.bshg.validation.exceptions;

import org.bshg.validation.results.TypeValidateResult;
import org.bshg.validation.results.ValidatorResult;

import java.util.List;

public class ValidatorException extends RuntimeException {
    private final int status = 400;
    private final ValidatorResult results;

    public ValidatorException(ValidatorResult results) {
        this.results = results;
    }

    public int getStatus() {
        return status;
    }

    public ValidatorResult getResults() {
        return results;
    }
}