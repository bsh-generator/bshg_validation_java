package org.bshg.validation.typevalidators.config;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public record ValidatorFnConfig<T, TO>(
            Function<T, Boolean> error,
            BiFunction<T, TO, Boolean> errorDepend,
            String message,
            Supplier<String> messageFn
    ) {
        public ValidatorFnConfig(Function<T, Boolean> error, String message) {
            this(error, null, message, null);
        }

        public ValidatorFnConfig(BiFunction<T, TO, Boolean> errorDepend, String message) {
            this(null, errorDepend, message, null);
        }

        public ValidatorFnConfig(Function<T, Boolean> error, Supplier<String> message) {
            this(error, null, null, message);
        }

        public ValidatorFnConfig(BiFunction<T, TO, Boolean> errorDepend, Supplier<String> message) {
            this(null, errorDepend, null, message);
        }
    }