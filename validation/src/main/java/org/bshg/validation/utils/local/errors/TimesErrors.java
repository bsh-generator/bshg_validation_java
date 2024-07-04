package org.bshg.validation.utils.local.errors;

public record TimesErrors(
        String required,
        String equal,
        String after,
        String before,
        String between,
        String past,
        String future,
        String todayOrAfter,
        String todayOrBefore,
        String weekday,
        String weekend,
        String leapYear
) {
}