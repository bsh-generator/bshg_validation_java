package org.bshg.validation.typevalidators.number;

import org.bshg.validation.typevalidators.TypeValidator;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public interface Numbers<TNumber, TObject, TTypeValidator extends Numbers<TNumber, TObject, TTypeValidator>> extends TypeValidator<TNumber, TObject> {
    @Override
    TTypeValidator onError(Function<TNumber, Boolean> error, String message);

    @Override
    TTypeValidator onError(Function<TNumber, Boolean> error, Supplier<String> message);

    @Override
    TTypeValidator onError(BiFunction<TNumber, TObject, Boolean> error, String message);

    @Override
    TTypeValidator onError(BiFunction<TNumber, TObject, Boolean> error, Supplier<String> message);

    ///////////////////////////////////
    TTypeValidator required();

    TTypeValidator min(TNumber minValue);

    TTypeValidator max(TNumber maxValue);

    TTypeValidator range(TNumber minValue, TNumber maxValue);

    TTypeValidator positive();

    TTypeValidator negative();

    TTypeValidator multipleOf(TNumber divisor);

    TTypeValidator betweenExclusive(TNumber minValue, TNumber maxValue);

    TTypeValidator even();

    TTypeValidator odd();

    TTypeValidator divisibleBy(TNumber divisor);

    TTypeValidator perfectSquare();

    TTypeValidator primeNumber();

    TTypeValidator fibonacciNumber();
}
