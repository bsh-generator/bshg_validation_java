package org.bshg.validation.typevalidators.date.impl;

import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.date.LocalTimes;
import org.bshg.validation.utils.local.LocalUtils;
import org.bshg.validation.utils.local.errors.TimesErrors;

import java.time.LocalTime;
import java.util.Objects;

public class LocalTimesImpl<TO> extends TypeValidatorImpl<LocalTime, TO, LocalTimes<TO>> implements LocalTimes<TO> {
    protected TimesErrors errors() {
        return LocalUtils.local().messages().time();
    }

    @Override
    public LocalTimes<TO> required() {
        return onError(Objects::isNull, errors().required());
    }

    @Override
    public LocalTimes<TO> equal(LocalTime localTime) {
        return onError(value -> !value.equals(localTime), errors().equal(), new Object[]{localTime});
    }

    @Override
    public LocalTimes<TO> after(LocalTime localTime) {
        return onError(value -> !value.isAfter(localTime), errors().after(), new Object[]{localTime});
    }

    @Override
    public LocalTimes<TO> before(LocalTime localTime) {
        return onError(value -> !value.isBefore(localTime), errors().before(), new Object[]{localTime});
    }

    @Override
    public LocalTimes<TO> between(LocalTime start, LocalTime end) {
        return onError(value -> value.isBefore(start) || value.isAfter(end), errors().between(), new Object[]{start, end});
    }

    @Override
    public LocalTimes<TO> past() {
        return onError(value -> !value.isBefore(LocalTime.now()), errors().past());
    }

    @Override
    public LocalTimes<TO> future() {
        return onError(value -> !value.isAfter(LocalTime.now()), errors().future());
    }
}