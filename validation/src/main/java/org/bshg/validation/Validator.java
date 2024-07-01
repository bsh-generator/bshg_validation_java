package org.bshg.validation;

import org.bshg.validation.exceptions.ValidatorException;

import java.util.ArrayList;
import java.util.List;

public class Validator<T> {
    private T item;
    private List<Validator<?>> nestedValidators;
    private List<ValidatorItem<?, T>> validatorItems;
    private List<ValidateResult<?>> results;

    private Validator() {
    }

    public Validator(T item) {
        this.item = item;
    }

    public void applyAll() {
        this.validatorItems.forEach(it -> it.validate(this.item));
    }

    public void reset() {
        this.validatorItems.forEach(ValidatorItem::reset);
    }

    public void validate() {
        this.applyAll();
        results = new ArrayList<>();
        this.validatorItems.forEach(it -> results.add(it.result()));
        if (this.nestedValidators != null) {
            this.nestedValidators.forEach(it -> {
                it.applyAll();
                it.validatorItems.forEach(item -> results.add(item.result()));
            });
        }
        if (results.stream().anyMatch(it -> !it.isValid())) {
            throw new ValidatorException(results);
        }
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public void setNestedValidators(List<Validator<?>> nestedValidators) {
        this.nestedValidators = nestedValidators;
    }

    public List<ValidateResult<?>> getResults() {
        return results;
    }

    public List<ValidatorItem<?, T>> getValidatorItems() {
        if (validatorItems == null) validatorItems = new ArrayList<>();
        return validatorItems;
    }
}
