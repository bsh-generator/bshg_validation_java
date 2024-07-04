package org.bshg.validation.typevalidators.string;

import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.utils.Regex;
import org.bshg.validation.utils.local.LocalUtils;
import org.bshg.validation.utils.local.errors.StringsErrors;

import java.util.Objects;
import java.util.regex.Pattern;

public class StringsImpl<TO> extends TypeValidatorImpl<String, TO, Strings<TO>> implements Strings<TO> {
    protected StringsErrors errors() {
        return LocalUtils.local().messages().string();
    }

    public Strings<TO> required() {
        return onError(Objects::isNull, "This field is required!");
    }

    public Strings<TO> notEmpty() {
        return onError(value -> value != null && value.isEmpty(), errors().notEmpty());
    }

    public Strings<TO> min(int length) {
        return onError(
                value -> value != null && value.length() < length,
                errors().min(), new Object[]{length}
        );
    }

    public Strings<TO> max(int length) {
        return onError(
                value -> value != null && value.length() > length,
                errors().max(), new Object[]{length}
        );
    }

    public Strings<TO> includes(String substring) {
        return onError(
                value -> value != null && !value.contains(substring),
                errors().includes(), new Object[]{substring}
        );
    }

    public Strings<TO> includesAll(String[] substrings) {
        return onError(
                value -> value != null && !java.util.Arrays.stream(substrings).allMatch(value::contains),
                errors().includesAll(), new Object[]{String.join(", ", substrings)}
        );
    }

    public Strings<TO> startsWith(String prefix) {
        return onError(
                value -> value != null && !value.startsWith(prefix),
                errors().startsWith(), new Object[]{prefix}
        );
    }

    public Strings<TO> endsWith(String suffix) {
        return onError(
                value -> value != null && !value.endsWith(suffix),
                errors().startsWith(), new Object[]{suffix}
        );
    }

    public Strings<TO> matches(Pattern pattern) {
        return onError(value -> value != null && !pattern.matcher(value).matches(), errors().matches());
    }

    public Strings<TO> matches(Pattern pattern, String message) {
        return onError(value -> value != null && !pattern.matcher(value).matches(), message);
    }

    public Strings<TO> email() {
        return matches(Regex.EMAIL, errors().email());
    }

    public Strings<TO> phone() {
        return matches(Regex.PHONE, errors().phone());
    }

    public Strings<TO> url() {
        return matches(Regex.URL, errors().url());
    }

    public Strings<TO> date() {
        return matches(Regex.DATE, errors().date());
    }

    public Strings<TO> time() {
        return matches(Regex.TIME, errors().time());
    }

    public Strings<TO> hexColor() {
        return matches(Regex.HEX_COLOR, errors().hexColor());
    }

    public Strings<TO> creditCard() {
        return matches(Regex.CREDIT_CARD, errors().creditCard());
    }

    public Strings<TO> htmlTag() {
        return matches(Regex.HTML_TAG, errors().htmlTag());
    }

    public Strings<TO> base64() {
        return matches(Regex.BASE64, errors().base64());
    }

    public Strings<TO> alphanumeric() {
        return matches(Regex.ALPHANUMERIC, errors().alphanumeric());
    }

    public Strings<TO> numeric() {
        return matches(Regex.NUMERIC, errors().numeric());
    }

    public Strings<TO> alpha() {
        return matches(Regex.ALPHA, errors().alpha());
    }
}