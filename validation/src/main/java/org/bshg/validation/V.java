package org.bshg.validation;

import org.bshg.validation.typevalidators.TypeValidator;
import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.array.Lists;
import org.bshg.validation.typevalidators.array.Sets;
import org.bshg.validation.typevalidators.array.impl.ListsImpl;
import org.bshg.validation.typevalidators.array.impl.SetsImpl;
import org.bshg.validation.typevalidators.bool.Booleans;
import org.bshg.validation.typevalidators.bool.BooleansImpl;
import org.bshg.validation.typevalidators.date.Dates;
import org.bshg.validation.typevalidators.date.LocalDateTimes;
import org.bshg.validation.typevalidators.date.LocalDates;
import org.bshg.validation.typevalidators.date.LocalTimes;
import org.bshg.validation.typevalidators.date.impl.DatesImpl;
import org.bshg.validation.typevalidators.date.impl.LocalDateTimesImpl;
import org.bshg.validation.typevalidators.date.impl.LocalDatesImpl;
import org.bshg.validation.typevalidators.date.impl.LocalTimesImpl;
import org.bshg.validation.typevalidators.number.*;
import org.bshg.validation.typevalidators.number.impl.*;
import org.bshg.validation.typevalidators.string.Strings;
import org.bshg.validation.typevalidators.string.StringsImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class V {
    ////////////////////////////
    //////// COSTUME ///////////
    ////////////////////////////
    public static <T, TO> TypeValidator<T, TO, ?> costume(ValidatorItem<T, TO> item) {
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

    ////////////////////////////
    ///////// BOOLEANS /////////
    ////////////////////////////
    public static <TO> Booleans<TO> bool(ValidatorItem<Boolean, TO> item) {
        return new BooleansImpl<>();
    }

    ////////////////////////////
    //// DATES AND TIMES ///////
    ////////////////////////////
    public static <TO> Dates<TO> date(ValidatorItem<Date, TO> item) {
        return new DatesImpl<>();
    }

    public static <TO> LocalDates<TO> localDate(ValidatorItem<LocalDate, TO> item) {
        return new LocalDatesImpl<>();
    }

    public static <TO> LocalDateTimes<TO> localDateTimes(ValidatorItem<LocalDateTime, TO> item) {
        return new LocalDateTimesImpl<>();
    }

    public static <TO> LocalTimes<TO> localTime(ValidatorItem<LocalTime, TO> item) {
        return new LocalTimesImpl<>();
    }

    ////////////////////////////
    ////////// ARRAYS //////////
    ////////////////////////////
    public static <T, TO> Lists<T, TO> list(ValidatorItem<List<T>, TO> item) {
        return new ListsImpl<>();
    }

    public static <T, TO> Sets<T, TO> set(ValidatorItem<Set<T>, TO> item) {
        return new SetsImpl<>();
    }
}