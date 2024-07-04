package org.bshg.validation.utils.local.errors;

public record ArraysErrors(
        String required,
        String minSize,
        String maxSize,
        String sizeBetween,
        String contains,
        String satisfies
) {
}