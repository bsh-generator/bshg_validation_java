package org.bshg.validation.utils.local.errors;

public record StringsErrors(
        String required,
        String notEmpty,
        String min,
        String max,
        String includes,
        String includesAll,
        String startsWith,
        String endsWith,
        String matches,
        String email,
        String phone,
        String url,
        String date,
        String time,
        String hexColor,
        String creditCard,
        String htmlTag,
        String base64,
        String alphanumeric,
        String numeric,
        String alpha
) {
}