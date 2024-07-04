package org.bshg.validation.typevalidators.date.impl;

import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.date.LocalDateTimes;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Objects;

public class LocalDateTimesImpl<TO> extends TypeValidatorImpl<LocalDateTime, TO, LocalDateTimes<TO>> implements LocalDateTimes<TO> {
    @Override
    public LocalDateTimes<TO> required() {
        return onError(Objects::isNull, "This field is required!");
    }

    @Override
    public LocalDateTimes<TO> equal(LocalDateTime localDateTime) {
        return onError(value -> !value.equals(localDateTime), "DateTime must be equal to " + localDateTime);
    }

    @Override
    public LocalDateTimes<TO> after(LocalDateTime localDateTime) {
        return onError(value -> !value.isAfter(localDateTime), "DateTime must be after " + localDateTime);
    }

    @Override
    public LocalDateTimes<TO> before(LocalDateTime localDateTime) {
        return onError(value -> !value.isBefore(localDateTime), "DateTime must be before " + localDateTime);
    }

    @Override
    public LocalDateTimes<TO> between(LocalDateTime start, LocalDateTime end) {
        return onError(value -> value.isBefore(start) || value.isAfter(end), "DateTime must be between " + start + " and " + end);
    }

    @Override
    public LocalDateTimes<TO> past() {
        return onError(value -> !value.isBefore(LocalDateTime.now()), "DateTime must be in the past");
    }

    @Override
    public LocalDateTimes<TO> future() {
        return onError(value -> !value.isAfter(LocalDateTime.now()), "DateTime must be in the future");
    }

    @Override
    public LocalDateTimes<TO> todayOrAfter() {
        return onError(value -> value.isBefore(startOfDay(LocalDateTime.now())), "DateTime must be today or after");
    }

    @Override
    public LocalDateTimes<TO> todayOrBefore() {
        return onError(value -> value.isAfter(endOfDay(LocalDateTime.now())), "DateTime must be today or before");
    }

    @Override
    public LocalDateTimes<TO> weekday() {
        return onError(value -> {
            DayOfWeek dayOfWeek = value.getDayOfWeek();
            return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
        }, "DateTime must be a weekday");
    }

    @Override
    public LocalDateTimes<TO> weekend() {
        return onError(value -> {
            DayOfWeek dayOfWeek = value.getDayOfWeek();
            return dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
        }, "DateTime must be a weekend");
    }

    @Override
    public LocalDateTimes<TO> leapYear() {
        return onError(value -> !value.toLocalDate().isLeapYear(), "DateTime must be in a leap year");
    }

    private LocalDateTime startOfDay(LocalDateTime dateTime) {
        return dateTime.toLocalDate().atStartOfDay();
    }

    private LocalDateTime endOfDay(LocalDateTime dateTime) {
        return dateTime.toLocalDate().atTime(23, 59, 59, 999999999);
    }
}