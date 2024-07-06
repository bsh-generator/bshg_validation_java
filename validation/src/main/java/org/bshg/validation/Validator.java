package org.bshg.validation;

import org.bshg.validation.exceptions.ValidatorException;
import org.bshg.validation.results.ValidatorResult;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Validator<T> {
    private T item;
    private List<Validator<?>> nestedValidators;
    private List<ValidatorItem<?, T>> validatorItems;

    private ValidatorResult results;

    public Validator() {
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
        results = new ValidatorResult();
        var itemsResult = results.items();

        this.validatorItems.forEach(it -> itemsResult.add(it.result()));
//        if (this.nestedValidators != null) {
//            this.nestedValidators.forEach(it -> {
//                it.applyAll();
//                it.validatorItems.forEach(item -> results.add(item.result()));
//            });
//        }

        // throw exception
        if (results.errorFound()) throw new ValidatorException(results);
    }

    public void validate(T item) {
        this.item = item;
        this.validate();
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

    public ValidatorResult getResults() {
        return results;
    }

    public List<ValidatorItem<?, T>> getValidatorItems() {
        if (validatorItems == null) validatorItems = new ArrayList<>();
        return validatorItems;
    }

    /////////////
    protected <Type> ValidatorItem.Builder<Type, T> item(Supplier<Type> field) {
        return ValidatorItem.builder(this, field);
    }
}