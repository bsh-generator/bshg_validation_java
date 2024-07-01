package org.bshg.validation.typevalidators.string;

import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.utils.Regex;

import java.util.Objects;
import java.util.regex.Pattern;

public class StringsImpl<TO> extends TypeValidatorImpl<String, TO, Strings<TO>> implements Strings<TO> {
    public Strings<TO> required() {
        return onError(Objects::isNull, "This field is required!");
    }

    public Strings<TO> notEmpty() {
        return onError(value -> value != null && value.isEmpty(), errors().notEmpty());
    }

    public Strings<TO> min(int length) {
        return onError(value -> value != null && value.length() < length, "This field must have at least " + length + " characters!");
    }

    public Strings<TO> max(int length) {
        return onError(value -> value != null && value.length() > length, "This field must have at most " + length + " characters!");
    }

    public Strings<TO> includes(String substring) {
        return onError(value -> value != null && !value.contains(substring), "This field must include '" + substring + "'!");
    }

    public Strings<TO> includesAll(String[] substrings) {
        return onError(value -> value != null && !java.util.Arrays.stream(substrings).allMatch(value::contains), "This field must include all of: " + String.join(", ", substrings) + "!");
    }

    public Strings<TO> startsWith(String prefix) {
        return onError(value -> value != null && !value.startsWith(prefix), "This field must start with '" + prefix + "'!");
    }

    public Strings<TO> endsWith(String suffix) {
        return onError(value -> value != null && !value.endsWith(suffix), "This field must end with '" + suffix + "'!");
    }

    public Strings<TO> matches(Pattern pattern) {
        return onError(value -> value != null && !pattern.matcher(value).matches(), "This field must match the pattern!");
    }

    public Strings<TO> matches(Pattern pattern, String message) {
        return onError(value -> value != null && !pattern.matcher(value).matches(), message);
    }

    public Strings<TO> email() {
        return matches(Regex.EMAIL, "This field must be a valid email!");
    }

    public Strings<TO> phone() {
        return matches(Regex.PHONE, "This field must be a valid phone number!");
    }

    public Strings<TO> url() {
        return matches(Regex.URL, "This field must be a valid URL!");
    }

    public Strings<TO> date() {
        return matches(Regex.DATE, "This field must be a valid date (YYYY-MM-DD)!");
    }

    public Strings<TO> time() {
        return matches(Regex.TIME, "This field must be a valid time (HH:MM or HH:MM:SS)!");
    }

    public Strings<TO> hexColor() {
        return matches(Regex.HEX_COLOR, "This field must be a valid hex color!");
    }

    public Strings<TO> creditCard() {
        return matches(Regex.CREDIT_CARD, "This field must be a valid credit card number!");
    }

    public Strings<TO> htmlTag() {
        return matches(Regex.HTML_TAG, "This field must be a valid HTML tag!");
    }

    public Strings<TO> base64() {
        return matches(Regex.BASE64, "This field must be a valid Base64 string!");
    }

    public Strings<TO> alphanumeric() {
        return matches(Regex.ALPHANUMERIC, "This field must be alphanumeric!");
    }

    public Strings<TO> numeric() {
        return matches(Regex.NUMERIC, "This field must be numeric!");
    }

    public Strings<TO> alpha() {
        return matches(Regex.ALPHA, "This field must contain only letters!");
    }
}
