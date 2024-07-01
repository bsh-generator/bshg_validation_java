package org.bshg.validation.typevalidators.date.base;

import org.bshg.validation.typevalidators.TypeValidator;

interface BaseDateType<TDate, TObject, TTypeValidator extends BaseDateType<TDate, TObject, TTypeValidator>>
        extends TypeValidator<TDate, TObject, TTypeValidator> {

    TTypeValidator required();

    TTypeValidator equal(TDate date);

    TTypeValidator after(TDate date);

    TTypeValidator before(TDate date);

    TTypeValidator between(TDate start, TDate end);

    TTypeValidator past();

    TTypeValidator future();
}
