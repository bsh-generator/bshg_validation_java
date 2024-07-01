package org.bshg.validation.utils.local;

import org.bshg.validation.utils.local.errors.*;

public record ErrorMessage(
        StringsErrors string,
        NumbersErrors number,
        BooleansErrors bool,
        ArraysErrors array,
        DatesErrors date,
        DateTimesErrors datetime,
        TimesErrors time
) { }