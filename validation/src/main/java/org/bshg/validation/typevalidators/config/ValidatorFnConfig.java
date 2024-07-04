package org.bshg.validation.typevalidators.config;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public record ValidatorFnConfig<T, TO>(
        Function<T, Boolean> error,
        BiFunction<T, TO, Boolean> errorDepend,
        String message,
        Supplier<String> messageFn,
        Object[]... args
) {
    public ValidatorFnConfig(Function<T, Boolean> error, String message, Object[]... args) {
        this(error, null, message, null, args);
    }

    public ValidatorFnConfig(BiFunction<T, TO, Boolean> errorDepend, String message, Object[]... args) {
        this(null, errorDepend, message, null, args);
    }

    public ValidatorFnConfig(Function<T, Boolean> error, Supplier<String> message, Object[]... args) {
        this(error, null, null, message, args);
    }

    public ValidatorFnConfig(BiFunction<T, TO, Boolean> errorDepend, Supplier<String> message, Object[]... args) {
        this(null, errorDepend, null, message, args);
    }
}