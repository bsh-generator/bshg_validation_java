package org.bshg.validation.typevalidators.date.base;

interface BaseDateType2<TDate, TObject, TTypeValidator extends BaseDateType2<TDate, TObject, TTypeValidator>>
        extends BaseDateType<TDate, TObject, TTypeValidator> {

    TTypeValidator todayOrAfter();

    TTypeValidator todayOrBefore();

    TTypeValidator weekday();

    TTypeValidator weekend();

    TTypeValidator leapYear();
}
