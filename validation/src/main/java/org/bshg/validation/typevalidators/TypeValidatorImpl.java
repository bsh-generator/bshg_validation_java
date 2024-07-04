package org.bshg.validation.typevalidators;

import org.bshg.validation.ValidatorItem;
import org.bshg.validation.typevalidators.config.ValidatorFnConfig;
import org.bshg.validation.utils.local.LocalUtils;
import org.bshg.validation.utils.local.errors.StringsErrors;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class TypeValidatorImpl<T, TO, TTypeValidator extends TypeValidator<T, TO, TTypeValidator>>
        implements TypeValidator<T, TO, TTypeValidator> {
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
    public TTypeValidator onError(Function<T, Boolean> error, String message) {
        getValidations().add(new ValidatorFnConfig<>(error, message));
        return self();
    }

    @Override
    public TTypeValidator onError(Function<T, Boolean> error, Supplier<String> message) {
        getValidations().add(new ValidatorFnConfig<>(error, message));
        return self();
    }

    @Override
    public TTypeValidator onError(BiFunction<T, TO, Boolean> error, String message) {
        getValidations().add(new ValidatorFnConfig<>(error, message));
        return self();
    }

    @Override
    public TTypeValidator onError(BiFunction<T, TO, Boolean> error, Supplier<String> message) {
        getValidations().add(new ValidatorFnConfig<>(error, message));
        return self();
    }

    @SuppressWarnings("unchecked")
    private TTypeValidator self() {
        return (TTypeValidator) this;
    }
}