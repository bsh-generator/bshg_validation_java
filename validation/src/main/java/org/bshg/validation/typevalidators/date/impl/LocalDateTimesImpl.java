package org.bshg.validation.typevalidators.date.impl;

import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.date.LocalDateTimes;

import java.time.LocalDateTime;

public class LocalDateTimesImpl<TO> extends TypeValidatorImpl<LocalDateTime, TO, LocalDateTimes<TO>> implements LocalDateTimes<TO> {
//    @Override
//    public DateTimesImpl onError(boolean errorCondition, String errorMsg) {
//        super.onError(errorCondition, errorMsg);
//        return this;
//    }
//
//    public DateTimesImpl required() {
//        return onError(this.value() == null, "This field is required!");
//    }
}
