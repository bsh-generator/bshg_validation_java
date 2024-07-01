package org.bshg.validation;

import org.bshg.validation.exceptions.ValidatorException;

import java.util.List;
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
//        private final ValidatorItem<String, User> username = ValidatorItem.build(
//                this, "username",
//                () -> this.getItem().username(),
//                V.string(this.username).required().notEmpty().alpha()
//        );
//        private final ValidatorItem<Role> role = new ValidatorItem<>(
//                this, "role",
//                () -> this.getItem().role(),
//                V.costume()
//                        .onError(value -> value.local() == null, "local is required")
//        );

        public UserValidator(User item) {
            super(item);
        }

        public static void validate(User item) {
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
                .validations(V.string(this.password).required())
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
                .validations(V.longy(this.id).required().positive())
                .build();
    }

    public static void main(String[] args) {
        User user = new User(
                "BSH.G",
                "password",
                "password2",
                new Role(null),
                100L
        );

        try {
            UserValidator.validate(user);
        } catch (ValidatorException e) {
            List<ValidateResult<?>> results = e.getResults();
            results.forEach(it -> System.out.println(it.getField() + ": " + it.isValid() + " -> " + it.getMessage()));
        }
    }
}
