package org.bshg.validation.utils.local.errors;

public record NumbersErrors(
        String required,
        String min,
        String max,
        String range,
        String positive,
        String negative,
        String multipleOf,
        String betweenExclusive,
        String even,
        String odd,
        String divisibleBy,
        String perfectSquare,
        String primeNumber,
        String fibonacciNumber,
        String powerOfTwo
) {
}