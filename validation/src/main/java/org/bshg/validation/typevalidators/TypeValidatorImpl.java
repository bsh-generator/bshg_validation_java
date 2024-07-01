package org.bshg.validation.typevalidators;

import org.bshg.validation.ValidatorItem;
import org.bshg.validation.typevalidators.config.ValidatorFnConfig;
import org.bshg.validation.utils.local.LocalUtils;
import org.bshg.validation.utils.local.errors.StringsErrors;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class TypeValidatorImpl<T, TO> implements TypeValidator<T, TO> {
    public TypeValidatorImpl() {
    }

    public TypeValidatorImpl(ValidatorItem<T, TO> validatorItem) {
        this.validatorItem = validatorItem;
    }

    private ValidatorItem<T, TO> validatorItem;

    protected T value() {
        return this.validatorItem.getField().get();
    }

    protected void error(String msg) {
        this.validatorItem.error(msg);
    }

    public TypeValidator<T, TO> required() {
        return onError(Objects::isNull, "This field is required!");
    }

    protected StringsErrors errors() {
        return LocalUtils.local().messages().string();
    }

    private List<ValidatorFnConfig<T, TO>> validations;

    @Override
    public List<ValidatorFnConfig<T, TO>> getValidations() {
        if (validations == null)
            validations = new ArrayList<>();
        return validations;
    }

    @Override
    public TypeValidator<T, TO> onError(Function<T, Boolean> error, String message) {
        getValidations().add(new ValidatorFnConfig<>(error, message));
        return this;
    }

    @Override
    public TypeValidator<T, TO> onError(Function<T, Boolean> error, Supplier<String> message) {
        getValidations().add(new ValidatorFnConfig<>(error, message));
        return this;
    }

    @Override
    public TypeValidator<T, TO> onError(BiFunction<T, TO, Boolean> error, String message) {
        getValidations().add(new ValidatorFnConfig<>(error, message));
        return this;
    }

    @Override
    public TypeValidator<T, TO> onError(BiFunction<T, TO, Boolean> error, Supplier<String> message) {
        getValidations().add(new ValidatorFnConfig<>(error, message));
        return this;
    }
}
