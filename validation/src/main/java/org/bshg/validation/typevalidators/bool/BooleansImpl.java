package org.bshg.validation.typevalidators.bool;

import org.bshg.validation.ValidatorItem;
import org.bshg.validation.typevalidators.TypeValidatorImpl;

public class BooleansImpl<TO> extends TypeValidatorImpl<Boolean, TO> implements Booleans<TO> {
    public BooleansImpl(ValidatorItem<Boolean, TO> validatorItem) {
        super(validatorItem);
    }

//    @Override
//    public BooleansImpl onError(boolean errorCondition, String errorMsg) {
//        super.onError(errorCondition, errorMsg);
//        return this;
//    }
//
//    public BooleansImpl required() {
//        return onError(this.value() == null, "This field is required!");
//    }

}
