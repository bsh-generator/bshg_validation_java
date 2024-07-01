package org.bshg.validation.typevalidators.date.impl;

import org.bshg.validation.ValidatorItem;
import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.date.Dates;

import java.time.LocalDate;

public class DatesImpl<TO> extends TypeValidatorImpl<LocalDate, TO> implements Dates<TO> {
    public DatesImpl(ValidatorItem<LocalDate, TO> validatorItem) {
        super(validatorItem);
    }

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
