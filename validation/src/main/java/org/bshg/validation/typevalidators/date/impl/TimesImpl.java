package org.bshg.validation.typevalidators.date.impl;

import org.bshg.validation.ValidatorItem;
import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.date.Times;

import java.time.LocalTime;

public class TimesImpl<TO> extends TypeValidatorImpl<LocalTime, TO> implements Times<TO> {
    public TimesImpl(ValidatorItem<LocalTime, TO> validatorItem) {
        super(validatorItem);
    }

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
