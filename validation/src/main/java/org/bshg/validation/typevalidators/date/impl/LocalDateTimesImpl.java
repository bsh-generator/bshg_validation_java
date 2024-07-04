package org.bshg.validation.typevalidators.date.impl;

import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.date.LocalDateTimes;
import org.bshg.validation.utils.local.LocalUtils;
import org.bshg.validation.utils.local.errors.DateTimesErrors;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Objects;

public class LocalDateTimesImpl<TO> extends TypeValidatorImpl<LocalDateTime, TO, LocalDateTimes<TO>> implements LocalDateTimes<TO> {
    protected DateTimesErrors errors() {
        return LocalUtils.local().messages().datetime();
    }

    @Override
    public LocalDateTimes<TO> required() {
        return onError(Objects::isNull, errors().required());
    }

    @Override
    public LocalDateTimes<TO> equal(LocalDateTime localDateTime) {
        return onError(value -> !value.equals(localDateTime), errors().equal(), new Object[]{localDateTime});
    }

    @Override
    public LocalDateTimes<TO> after(LocalDateTime localDateTime) {
        return onError(value -> !value.isAfter(localDateTime), errors().after(), new Object[]{localDateTime});
    }

    @Override
    public LocalDateTimes<TO> before(LocalDateTime localDateTime) {
        return onError(value -> !value.isBefore(localDateTime), errors().before(), new Object[]{localDateTime});
    }

    @Override
    public LocalDateTimes<TO> between(LocalDateTime start, LocalDateTime end) {
        return onError(value -> value.isBefore(start) || value.isAfter(end), errors().between(), new Object[]{start, end});
    }

    @Override
    public LocalDateTimes<TO> past() {
        return onError(value -> !value.isBefore(LocalDateTime.now()), errors().past());
    }

    @Override
    public LocalDateTimes<TO> future() {
        return onError(value -> !value.isAfter(LocalDateTime.now()), errors().future());
    }

    @Override
    public LocalDateTimes<TO> todayOrAfter() {
        return onError(value -> value.isBefore(startOfDay(LocalDateTime.now())), errors().todayOrAfter());
    }

    @Override
    public LocalDateTimes<TO> todayOrBefore() {
        return onError(value -> value.isAfter(endOfDay(LocalDateTime.now())), errors().todayOrBefore());
    }

    @Override
    public LocalDateTimes<TO> weekday() {
        return onError(value -> {
            DayOfWeek dayOfWeek = value.getDayOfWeek();
            return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
        }, errors().weekday());
    }

    @Override
    public LocalDateTimes<TO> weekend() {
        return onError(value -> {
            DayOfWeek dayOfWeek = value.getDayOfWeek();
            return dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
        }, errors().weekend());
    }

    @Override
    public LocalDateTimes<TO> leapYear() {
        return onError(value -> !value.toLocalDate().isLeapYear(), errors().leapYear());
    }

    private LocalDateTime startOfDay(LocalDateTime dateTime) {
        return dateTime.toLocalDate().atStartOfDay();
    }

    private LocalDateTime endOfDay(LocalDateTime dateTime) {
        return dateTime.toLocalDate().atTime(23, 59, 59, 999999999);
    }
}