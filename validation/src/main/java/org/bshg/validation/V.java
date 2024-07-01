package org.bshg.validation;

import org.bshg.validation.typevalidators.TypeValidator;
import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.number.*;
import org.bshg.validation.typevalidators.number.impl.*;
import org.bshg.validation.typevalidators.string.Strings;
import org.bshg.validation.typevalidators.string.StringsImpl;

public class V {
    public static <T, TO> TypeValidator<T, TO> costume(ValidatorItem<T, TO> item) {
        return new TypeValidatorImpl<>();
    }

    ////////////////////////////
    //////// STRINGS ///////////
    ////////////////////////////
    public static <TO> Strings<TO> string(ValidatorItem<String, TO> item) {
        return new StringsImpl<>();
    }

    ////////////////////////////
    //////// NUMBERS ///////////
    ////////////////////////////
    public static <TO> Longs<TO> longs(ValidatorItem<Long, TO> item) {
        return new LongsImpl<>();
    }

    public static <TO> Integers<TO> integer(ValidatorItem<Integer, TO> item) {
        return new IntegersImpl<>();
    }

    public static <TO> Doubles<TO> doubles(ValidatorItem<Double, TO> item) {
        return new DoublesImpl<>();
    }

    public static <TO> Floats<TO> floats(ValidatorItem<Float, TO> item) {
        return new FloatsImpl<>();
    }

    public static <TO> BigDecimals<TO> bigDecimal(ValidatorItem<Float, TO> item) {
        return new BigDecimalsImpl<>();
    }

    /*
    ////////////////////////////
    ///////// BOOLEANS /////////
    ////////////////////////////
    public static Booleans bool(ValidatorItem<Boolean> item) {
        return new BooleansImpl(item);
    }

    ////////////////////////////
    ////////// DATES ///////////
    ////////////////////////////
    public static Dates date(ValidatorItem<LocalDate> item) {
        return new DatesImpl(item);
    }

    public static DateTimes datetime(ValidatorItem<LocalDateTime> item) {
        return new DateTimesImpl(item);
    }

    public static Times time(ValidatorItem<LocalTime> item) {
        return new TimesImpl(item);
    }

    ////////////////////////////
    ////////// ARRAYS //////////
    ////////////////////////////
    public static <T> Lists<T> list(ValidatorItem<List<T>> item) {
        return new ListsImpl<>(item);
    }

    public static <T> Sets<T> set(ValidatorItem<Set<T>> item) {
        return new SetsImpl<>(item);
    }*/
}
