package org.bshg.validation.typevalidators.date.impl;

import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.date.LocalTimes;

import java.time.LocalTime;
import java.util.Objects;

public class LocalTimesImpl<TO>
        extends TypeValidatorImpl<LocalTime, TO, LocalTimes<TO>>
        implements LocalTimes<TO> {

    @Override
    public LocalTimes<TO> required() {
        return onError(Objects::isNull, "This field is required!");
    }

    @Override
    public LocalTimes<TO> equal(LocalTime localTime) {
        return onError(value -> !value.equals(localTime), "Time must be equal to " + localTime);
    }

    @Override
    public LocalTimes<TO> after(LocalTime localTime) {
        return onError(value -> !value.isAfter(localTime), "Time must be after " + localTime);
    }

    @Override
    public LocalTimes<TO> before(LocalTime localTime) {
        return onError(value -> !value.isBefore(localTime), "Time must be before " + localTime);
    }

    @Override
    public LocalTimes<TO> between(LocalTime start, LocalTime end) {
        return onError(value -> value.isBefore(start) || value.isAfter(end), "Time must be between " + start + " and " + end);
    }

    @Override
    public LocalTimes<TO> past() {
        return onError(value -> !value.isBefore(LocalTime.now()), "Time must be in the past");
    }

    @Override
    public LocalTimes<TO> future() {
        return onError(value -> !value.isAfter(LocalTime.now()), "Time must be in the future");
    }
}