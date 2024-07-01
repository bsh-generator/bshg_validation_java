package org.bshg.validation.typevalidators.array.impl;

import org.bshg.validation.ValidatorItem;
import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.array.Sets;

import java.util.Set;

public class SetsImpl<T, TO> extends TypeValidatorImpl<Set<T>, TO> implements Sets<T, TO> {
    public SetsImpl(ValidatorItem<Set<T>, TO> validatorItem) {
        super(validatorItem);
    }

//    @Override
//    public SetsImpl<T> onError(boolean errorCondition, String errorMsg) {
//        super.onError(errorCondition, errorMsg);
//        return this;
//    }
//
//    public SetsImpl<T> required() {
//        return onError(this.value() == null, "This field is required!");
//    }

}
