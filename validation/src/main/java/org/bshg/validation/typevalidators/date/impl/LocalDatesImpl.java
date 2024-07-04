package org.bshg.validation.typevalidators.date.impl;

import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.date.LocalDates;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class LocalDatesImpl<TO>
        extends TypeValidatorImpl<LocalDate, TO, LocalDates<TO>>
        implements LocalDates<TO> {
    @Override
    public LocalDates<TO> required() {
        return onError(Objects::isNull, "This field is required!");
    }

    @Override
    public LocalDates<TO> equal(LocalDate localDate) {
        return onError(value -> !value.equals(localDate), "Date must be equal to " + localDate);
    }

    @Override
    public LocalDates<TO> after(LocalDate localDate) {
        return onError(value -> !value.isAfter(localDate), "Date must be after " + localDate);
    }

    @Override
    public LocalDates<TO> before(LocalDate localDate) {
        return onError(value -> !value.isBefore(localDate), "Date must be before " + localDate);
    }

    @Override
    public LocalDates<TO> between(LocalDate start, LocalDate end) {
        return onError(value -> value.isBefore(start) || value.isAfter(end), "Date must be between " + start + " and " + end);
    }

    @Override
    public LocalDates<TO> past() {
        return onError(value -> !value.isBefore(LocalDate.now()), "Date must be in the past");
    }

    @Override
    public LocalDates<TO> future() {
        return onError(value -> !value.isAfter(LocalDate.now()), "Date must be in the future");
    }

    @Override
    public LocalDates<TO> todayOrAfter() {
        return onError(value -> value.isBefore(LocalDate.now()), "Date must be today or after");
    }

    @Override
    public LocalDates<TO> todayOrBefore() {
        return onError(value -> value.isAfter(LocalDate.now()), "Date must be today or before");
    }

    @Override
    public LocalDates<TO> weekday() {
        return onError(value -> {
            DayOfWeek dayOfWeek = value.getDayOfWeek();
            return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
        }, "Date must be a weekday");
    }

    @Override
    public LocalDates<TO> weekend() {
        return onError(value -> {
            DayOfWeek dayOfWeek = value.getDayOfWeek();
            return dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
        }, "Date must be a weekend");
    }

    @Override
    public LocalDates<TO> leapYear() {
        return onError(value -> !value.isLeapYear(), "Date must be in a leap year");
    }
}