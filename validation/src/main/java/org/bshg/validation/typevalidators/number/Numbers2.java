package org.bshg.validation.typevalidators.number;

public interface Numbers2<TNumber, TObject, TTypeValidator extends Numbers2<TNumber, TObject, TTypeValidator>> extends Numbers<TNumber, TObject, TTypeValidator> {
    TTypeValidator powerOfTwo();
}
