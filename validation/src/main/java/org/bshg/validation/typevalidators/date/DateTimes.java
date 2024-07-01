package org.bshg.validation.typevalidators.date;

import org.bshg.validation.typevalidators.date.base.BaseDateTime;

import java.time.LocalDateTime;

public interface DateTimes<TO> extends BaseDateTime<LocalDateTime, TO, DateTimes<TO>> {
}
