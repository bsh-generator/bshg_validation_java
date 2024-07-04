package org.bshg.validation.typevalidators.date.impl;

import org.bshg.validation.typevalidators.TypeValidatorImpl;
import org.bshg.validation.typevalidators.date.Dates;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class DatesImpl<TO>
        extends TypeValidatorImpl<Date, TO, Dates<TO>>
        implements Dates<TO> {

    @Override
    public Dates<TO> required() {
        return onError(Objects::isNull, "This field is required!");
    }

    @Override
    public Dates<TO> equal(Date date) {
        return onError(value -> !value.equals(date), "Date must be equal to " + date);
    }

    @Override
    public Dates<TO> after(Date date) {
        return onError(value -> !value.after(date), "Date must be after " + date);
    }

    @Override
    public Dates<TO> before(Date date) {
        return onError(value -> !value.before(date), "Date must be before " + date);
    }

    @Override
    public Dates<TO> between(Date start, Date end) {
        return onError(value -> value.before(start) || value.after(end), "Date must be between " + start + " and " + end);
    }

    @Override
    public Dates<TO> past() {
        return onError(value -> value.after(new Date()), "Date must be in the past");
    }

    @Override
    public Dates<TO> future() {
        return onError(value -> value.before(new Date()), "Date must be in the future");
    }

    @Override
    public Dates<TO> todayOrAfter() {
        return onError(value -> value.before(startOfDay(new Date())), "Date must be today or after");
    }

    @Override
    public Dates<TO> todayOrBefore() {
        return onError(value -> value.after(endOfDay(new Date())), "Date must be today or before");
    }

    @Override
    public Dates<TO> weekday() {
        return onError(value -> {
            Calendar cal = Calendar.getInstance();
            cal.setTime(value);
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;
        }, "Date must be a weekday");
    }

    @Override
    public Dates<TO> weekend() {
        return onError(value -> {
            Calendar cal = Calendar.getInstance();
            cal.setTime(value);
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            return dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY;
        }, "Date must be a weekend");
    }

    @Override
    public Dates<TO> leapYear() {
        return onError(value -> {
            Calendar cal = Calendar.getInstance();
            cal.setTime(value);
            int year = cal.get(Calendar.YEAR);
            return !isLeapYear(year);
        }, "Date must be in a leap year");
    }

    private boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else return year % 400 == 0;
    }

    private Date startOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    private Date endOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }
}