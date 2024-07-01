package org.bshg.validation.typevalidators.date.impl;

import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.date.LocalTimes;

import java.time.LocalTime;

public class LocalTimesImpl<TO> extends TypeValidatorImpl<LocalTime, TO, LocalTimes<TO>> implements LocalTimes<TO> {
//    @Override
//    public TimesImpl onError(boolean errorCondition, String errorMsg) {
//        super.onError(errorCondition, errorMsg);
//        return this;
//    }
//
//    public TimesImpl required() {
//        return onError(this.value() == null, "This field is required!");
//    }
}
