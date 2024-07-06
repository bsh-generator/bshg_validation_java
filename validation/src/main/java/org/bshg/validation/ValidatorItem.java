package org.bshg.validation;

import org.bshg.validation.results.TypeValidateResult;
import org.bshg.validation.typevalidators.TypeValidator;
import org.bshg.validation.typevalidators.config.ValidatorFnConfig;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.regex.Pattern;

public class ValidatorItem<T, TO> {
    private boolean valid;
    private String message;
    private Supplier<T> field;
    private String fieldName;

    public void reset() {
        this.valid = false;
        this.message = null;
    }

    private void setMessage(ValidatorFnConfig<T, TO> fn) {
        var message = fn.messageFn() != null ? fn.messageFn().get() : fn.message();
        var args = fn.args();

        // Regular expression to find %n patterns
        var pattern = Pattern.compile("%(\\d+)");
        var matcher = pattern.matcher(message);

        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            var index = Integer.parseInt(matcher.group(1)) - 1;
            var replacement = index < args.length ? Arrays.toString(args[index]) : "[null]";
            // TODO remove [...] from the result
            matcher.appendReplacement(sb, replacement);
        }
        matcher.appendTail(sb);

        this.message = sb.toString();
    }


    public void error(String msg) {
        this.valid = false;
        this.message = msg;
    }

    private void error(ValidatorFnConfig<T, TO> fn) {
        this.valid = false;
        this.setMessage(fn);
    }

    public TypeValidateResult<T> result() {
        return result(null);
    }

    public TypeValidateResult<T> result(String prefix) {
        String fieldname = (prefix != null ? prefix + "." : "") + fieldName;
        return TypeValidateResult.of(field.get(), fieldname, valid, message);
    }

    // GETTERS AND SETTERS
    public boolean isValid() {
        return valid;
    }

    public void markAsValid() {
        this.valid = true;
        this.message = null;
    }

    public Supplier<T> getField() {
        return field;
    }

    ////////////////////////////////////////////////////7
    private List<ValidatorFnConfig<T, TO>> validations;

    private ValidatorItem() {
    }

    private void condition(ValidatorFnConfig<T, TO> fn, TO object) {
        var error = fn.errorDepend() != null ?
                fn.errorDepend().apply(this.field.get(), object) :
                fn.error() != null ?
                        fn.error().apply(this.field.get()) :
                        false;

        if (error) {
            this.error(fn);
            throw new RuntimeException();
        }
    }

    public void validate(TO object) {
        try {
            this.validations.forEach(it -> condition(it, object));
        } catch (RuntimeException e) {
            return;
        }
        this.markAsValid();
    }

    public static <T, TO> Builder<T, TO> builder(Validator<TO> container, Supplier<T> field) {
        return new Builder<>(container, field);
    }

    public static class Builder<T, TO> {
        private final ValidatorItem<T, TO> validatorItem;

        public Builder(Validator<TO> container, Supplier<T> field) {
            validatorItem = new ValidatorItem<>();
            validatorItem.field = field;
            container.getValidatorItems().add(validatorItem);
        }

        public Builder<T, TO> field(String fieldName) {
            validatorItem.fieldName = fieldName;
            return this;
        }

        public Builder<T, TO> validations(TypeValidator<T, TO, ?> validation) {
            validatorItem.validations = validation.getValidations();
            return this;
        }

        public ValidatorItem<T, TO> build() {
            return validatorItem;
        }
    }
}