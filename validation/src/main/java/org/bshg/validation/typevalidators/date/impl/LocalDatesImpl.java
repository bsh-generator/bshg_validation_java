package org.bshg.validation.typevalidators.date.impl;

import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.date.LocalDates;
import org.bshg.validation.utils.local.LocalUtils;
import org.bshg.validation.utils.local.errors.DatesErrors;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Objects;

public class LocalDatesImpl<TO>
        extends TypeValidatorImpl<LocalDate, TO, LocalDates<TO>>
        implements LocalDates<TO> {

    protected DatesErrors errors() {
        return LocalUtils.local().messages().date();
    }

    @Override
    public LocalDates<TO> required() {
        return onError(Objects::isNull, errors().required());
    }

    @Override
    public LocalDates<TO> equal(LocalDate localDate) {
        return onError(value -> !value.equals(localDate), errors().equal(), new Object[]{localDate});
    }

    @Override
    public LocalDates<TO> after(LocalDate localDate) {
        return onError(value -> !value.isAfter(localDate), errors().after(), new Object[]{localDate});
    }

    @Override
    public LocalDates<TO> before(LocalDate localDate) {
        return onError(value -> !value.isBefore(localDate), errors().before(), new Object[]{localDate});
    }

    @Override
    public LocalDates<TO> between(LocalDate start, LocalDate end) {
        return onError(value -> value.isBefore(start) || value.isAfter(end), errors().between(), new Object[]{start, end});
    }

    @Override
    public LocalDates<TO> past() {
        return onError(value -> !value.isBefore(LocalDate.now()), errors().past());
    }

    @Override
    public LocalDates<TO> future() {
        return onError(value -> !value.isAfter(LocalDate.now()), errors().future());
    }

    @Override
    public LocalDates<TO> todayOrAfter() {
        return onError(value -> value.isBefore(LocalDate.now()), errors().todayOrAfter());
    }

    @Override
    public LocalDates<TO> todayOrBefore() {
        return onError(value -> value.isAfter(LocalDate.now()), errors().todayOrBefore());
    }

    @Override
    public LocalDates<TO> weekday() {
        return onError(value -> {
            DayOfWeek dayOfWeek = value.getDayOfWeek();
            return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
        }, errors().weekday());
    }

    @Override
    public LocalDates<TO> weekend() {
        return onError(value -> {
            DayOfWeek dayOfWeek = value.getDayOfWeek();
            return dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
        }, errors().weekend());
    }

    @Override
    public LocalDates<TO> leapYear() {
        return onError(value -> !value.isLeapYear(), errors().leapYear());
    }
}