package org.bshg.validation;

import org.bshg.validation.exceptions.ValidatorException;

import java.time.LocalDate;
import java.util.Set;

public class Playground {

    record Role(String name) {
    }

    record User(
            String username,
            String password,
            String confirmPassword,
            int age,
            LocalDate birthday,
            Set<Role> roles
    ) {
    }

    static class UserValidator extends Validator<User> {

        public static void run(User object) {
            new UserValidator().validate(object);
        }

        // validator for username
        private final ValidatorItem<String, User> username =
                item(() -> this.getItem().username()) // create an instance of type `ValidatorItem<String, User>`
                        .field("username") // field name
                        .withRules( // set any rule to be applied on te attribute
                                V.string(this.username) // call string validator that provide building rules ready to use
                                        .required() // add required rule
                                        .notEmpty() // add not empty rule
                                        .alphanumeric() // add alphanumeric rule
                        )
                        .build(); // finally build the validator item

        private final ValidatorItem<String, User> password = ValidatorItem
                .builder(this, () -> this.getItem().password())
                .field("password")
                .withRules(
                        V.string(this.password)
                                .required()
                                .min(8)
                )
                .build();

        private final ValidatorItem<String, User> confirmPassword = ValidatorItem
                .builder(this, () -> this.getItem().confirmPassword())
                .field("confirmPassword")
                .withRules(
                        V.string(this.confirmPassword)
                                .required()
                                .onError( // define costume validation rule basing on the object itself
                                        (value, object) -> !object.password().equals(value),
                                        "Passwords not match"
                                )
                )
                .build();

        private final ValidatorItem<Integer, User> age = ValidatorItem
                .builder(this, () -> this.getItem().age())
                .field("age")
                .withRules(V.integer(this.age).positive())
                .build();

        private final ValidatorItem<LocalDate, User> birthday = ValidatorItem
                .builder(this, () -> this.getItem().birthday())
                .field("birthday")
                .withRules(V.localDate(this.birthday).past())
                .build();

        private final ValidatorItem<Set<Role>, User> roles = ValidatorItem
                .builder(this, () -> this.getItem().roles())
                .field("roles")
                .withRules(V.set(this.roles).satisfies(role -> role.name.startsWith("ROLE_")))
                .build();
    }

    public static void main(String[] args) {
        User user = new User(
                "BSH.G",
                "password",
                "pass word",
                20,
                LocalDate.of(2000, 4, 13),
                Set.of(new Role("ADMIN"), new Role("ROLE_USER"))
        );

        try {
            UserValidator.run(user);
        } catch (ValidatorException e) {
            var results = e.getResults().items();
            results.forEach(it -> System.out.println(it.getField() + ": " + it.isValid() + " -> " + it.getMessage()));
        }
    }
}