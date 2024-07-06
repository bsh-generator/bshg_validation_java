package org.bshg.validation;

import org.bshg.validation.exceptions.ValidatorException;

import java.util.Objects;

public class Playground {

    record Role(String name) {
    }

    record User(
            String username,
            String password,
            String confirmPassword,
            Role role,
            long id
    ) {
    }

    static class UserValidator extends Validator<User> {
        public UserValidator(User item) {
            super(item);
        }

        public static void run(User item) {
            new UserValidator(item).validate();
        }

        private final ValidatorItem<String, User> username = ValidatorItem
                .builder(this, () -> this.getItem().username())
                .field("username")
                .validations(V.string(this.username).required().notEmpty().alpha())
                .build();

        private final ValidatorItem<String, User> password = ValidatorItem
                .builder(this, () -> this.getItem().password())
                .field("password")
                .validations(V.string(this.password).required().min(10))
                .build();

        private final ValidatorItem<String, User> confirmPassword = ValidatorItem
                .builder(this, () -> this.getItem().confirmPassword())
                .field("confirmPassword")
                .validations(
                        V.string(this.confirmPassword)
                                .required()
                                .onError(value -> !Objects.equals(this.getItem().password(), value), "The Confirm must be as Password")
                )
                .build();

        private final ValidatorItem<Long, User> id = ValidatorItem
                .builder(this, () -> this.getItem().id())
                .field("id")
                .validations(
                        V.costume(this.id).onError(v -> v < 0, "Id must be positive")
                )
                .build();
    }

    public static void main(String[] args) {
        User user = new User(
                "BSH.G",
                "12345678",
                "password2",
                new Role(null),
                100L
        );

        try {
            UserValidator.run(user);
        } catch (ValidatorException e) {
            var results = e.getResults().items();
            results.forEach(it -> System.out.println(it.getField() + ": " + it.isValid() + " -> " + it.getMessage()));
        }
    }
}