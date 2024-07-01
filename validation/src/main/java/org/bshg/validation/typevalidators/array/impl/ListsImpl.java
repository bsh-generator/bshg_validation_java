package org.bshg.validation.typevalidators.array.impl;

import org.bshg.validation.ValidatorItem;
import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.array.Lists;

import java.util.List;

public class ListsImpl<T, TO> extends TypeValidatorImpl<List<T>, TO, Lists<T, TO>> implements Lists<T, TO> {
//    @Override
//    public ListsImpl<T> onError(boolean errorCondition, String errorMsg) {
//        super.onError(errorCondition, errorMsg);
//        return this;
//    }
//
//    public ListsImpl<T> required() {
//        return onError(this.value() == null, "This field is required!");
//    }

}
