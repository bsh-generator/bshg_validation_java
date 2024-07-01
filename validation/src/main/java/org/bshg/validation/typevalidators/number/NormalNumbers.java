package org.bshg.validation.typevalidators.number;

public interface NormalNumbers<TNumber, TObject, TTypeValidator extends NormalNumbers<TNumber, TObject, TTypeValidator>> extends Numbers<TNumber, TObject, TTypeValidator> {
    TTypeValidator powerOfTwo();
}
