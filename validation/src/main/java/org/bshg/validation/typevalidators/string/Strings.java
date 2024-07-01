package org.bshg.validation.typevalidators.string;

import org.bshg.validation.typevalidators.TypeValidator;

import java.util.regex.Pattern;

public interface Strings<TO> extends TypeValidator<String, TO, Strings<TO>> {
    Strings<TO> required();

    Strings<TO> notEmpty();

    Strings<TO> min(int length);

    Strings<TO> max(int length);

    Strings<TO> includes(String substring);

    Strings<TO> includesAll(String[] substrings);

    Strings<TO> startsWith(String prefix);

    Strings<TO> endsWith(String suffix);

    Strings<TO> matches(Pattern pattern);

    Strings<TO> matches(Pattern pattern, String message);

    Strings<TO> email();

    Strings<TO> phone();

    Strings<TO> url();

    Strings<TO> date();

    Strings<TO> time();

    Strings<TO> hexColor();

    Strings<TO> creditCard();

    Strings<TO> htmlTag();

    Strings<TO> base64();

    Strings<TO> alphanumeric();

    Strings<TO> numeric();

    Strings<TO> alpha();
}
