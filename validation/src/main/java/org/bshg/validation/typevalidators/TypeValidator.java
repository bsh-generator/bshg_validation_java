package org.bshg.validation.typevalidators;

import org.bshg.validation.typevalidators.config.ValidatorFnConfig;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public interface TypeValidator<T, TO> {
    TypeValidator<T, TO> required();

    List<ValidatorFnConfig<T, TO>> getValidations();

    TypeValidator<T, TO> onError(Function<T, Boolean> error, String message);
    TypeValidator<T, TO> onError(Function<T, Boolean> error, Supplier<String> message);

    TypeValidator<T, TO> onError(BiFunction<T, TO, Boolean> error, String message);
    TypeValidator<T, TO> onError(BiFunction<T, TO, Boolean> error, Supplier<String> message);
}
