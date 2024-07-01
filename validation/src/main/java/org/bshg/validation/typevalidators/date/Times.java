package org.bshg.validation.typevalidators.date;

import org.bshg.validation.typevalidators.date.base.BaseTime;

import java.time.LocalTime;

public interface Times<TO> extends BaseTime<LocalTime, TO, Times<TO>> {
}
