package org.bshg.validation.typevalidators.date.impl;

import org.bshg.validation.ValidatorItem;
import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.date.DateTimes;

import java.time.LocalDateTime;

public class DateTimesImpl<TO> extends TypeValidatorImpl<LocalDateTime, TO> implements DateTimes<TO> {
    public DateTimesImpl(ValidatorItem<LocalDateTime, TO> validatorItem) {
        super(validatorItem);
    }

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
