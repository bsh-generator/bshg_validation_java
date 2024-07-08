package org.bshg.validation;

import org.bshg.validation.results.ValidatorResult;

import java.util.List;

/**
 * Interface for the Validator.
 *
 * @param <T> the type of the item to be validated
 */
public interface IValidator<T> {

    /**
     * Applies all validation items.
     * This method triggers the validation process for all associated ValidatorItems.
     */
    void applyAll();

    /**
     * Resets all validation items.
     * This method clears the validation state of all associated ValidatorItems, making them ready for re-validation.
     */
    void reset();

    /**
     * Validates the item and collects the results.
     * This method runs the validation on the current item and gathers the results.
     * Throws a {@link org.bshg.validation.exceptions.ValidatorException ValidatorException} if any validation error is found.
     */
    void validate();

    /**
     * Validates a specified item.
     * This method sets the item to be validated and then performs the validation.
     *
     * @param item the item to be validated
     */
    default void validate(T item) {
        this.setItem(item);
        this.validate();
    }

    /**
     * Gets the item being validated.
     * This method returns the current item that is being validated.
     *
     * @return the item being validated
     */
    T getItem();

    /**
     * Sets the item to be validated.
     * This method sets the item that needs to be validated.
     *
     * @param item the item to set
     */
    void setItem(T item);

    /**
     * Sets the nested validators.
     * This method allows for setting a list of nested validators that can be used to validate complex objects with nested structures.
     *
     * @param nestedValidators the list of nested validators
     */
    void setNestedValidators(List<IValidator<?>> nestedValidators);

    /**
     * Gets the validation results.
     * This method returns the results of the validation process, encapsulated in a ValidatorResult object.
     *
     * @return the validation results
     */
    ValidatorResult getResults();

    /**
     * Gets the list of validation items.
     * This method returns a list of ValidatorItems, which represent individual validation rules applied to the item.
     *
     * @return the list of validation items
     */
    List<ValidatorItem<?, T>> getValidatorItems();
}
