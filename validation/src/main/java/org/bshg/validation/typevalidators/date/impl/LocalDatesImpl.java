package org.bshg.validation.typevalidators.date.impl;

import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.date.LocalDates;

import java.time.LocalDate;

public class LocalDatesImpl<TO> extends TypeValidatorImpl<LocalDate, TO, LocalDates<TO>> implements LocalDates<TO> {

//    @Override
//    public DatesImpl onError(boolean errorCondition, String errorMsg) {
//        super.onError(errorCondition, errorMsg);
//        return this;
//    }
//
//    public DatesImpl required() {
//        return onError(this.value() == null, "This field is required!");
//    }
}
