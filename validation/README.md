# @bshg/validation

Welcome to `@bshg/validation` for Java, a versatile Java library crafted for seamless data validation within your projects. this library empowers you to validate data in a declarative manner, ensuring your objects align with your expectations.

In this guide, you'll explore the features and functionalities of `@bshg/validation`, learning how to leverage its capabilities to fortify your projects with robust data validation.

Also see the [TypeScript version here]()

## Getting Started

Let's dive into the details of how to use this library effectively.

### Installation

To use our library, add `com.bshg.validation` dependency to your project via Maven or Gradle.

```xml
<dependency>
  <groupId>com.bshg.validation</groupId>
  <artifactId>core</artifactId>
  <version>${version}</version>
</dependency>
```

```groovy
implementation 'com.bshg.validation:core:<version>'
```

### Quick Example

in this example we will go to use the library to validate this Class:

```java
import java.time.LocalDate;
import java.util.Set;

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
```

the user class contains:
- username: must be provided and must be an alphanumeric
- password: must be provided and have at least 8 chars
- confirmPassword: required and must have the same value as password
- age: positive number and optional
- birthday: optional and must be in the past
- role: set of roles that must each item have a valid name starts with 'ROLE_' prefix

#### Create The Validator for our User objects

we need to create a class that extends `Validator<T>` from `org.bshg.validation`

````java
class UserValidator extends Validator<User> { }
````

then within it we will decalre the validation rules for each User field:

- for username:

````java
ValidatorItem<String, User> username =
    item(() -> this.getItem().username())
        .field("username")
        .withRules(
                V.string(this.username)
                        .required()
                        .notEmpty()
                        .alphanumeric()
        )
        .build();
````

let's explain each part:

- `ValidatorItem<String, User> username` here we declare an attr to validate the username, it is of type `ValidatorItem<Type, TObject>` with `Type` is the type of the field will be validated (e.g. String) and `TObject` is the type of the Object we are validating (e.g. User).
- `item(() -> this.getItem().username())` is to create an instance of `ValidatorItem`, this method require and `Supplier<Type>` function, must provide it to get the attribute value.
- `.field("username")` is used to set the name of the validated item, this will be used to know the error message and wish attribute correspond to.
- `.withRules(...)` this method used to define the rules that will be applied on the attribute.
- `V.string(this.username)` used to create an object to declare the rules.
- `.build();` finally you build your validatorItem.

here is the full example:

````java
class UserValidator extends Validator<User> {

    // we just add this function to simplify the using of it
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
````

after that the validator will be ready to use it in your application

````java
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
        UserValidator.run(user); // this will throw an exception in case of the validation are fails
    } catch (ValidatorException e) {
        var results = e.getResults().items();
        results.forEach(it -> System.out.println(it.getField() + ": " + it.isValid() + " -> " + it.getMessage()));
    }
}
````

the result is: 

````text
username: false -> Must contain only alphanumeric characters
password: true -> null
confirmPassword: false -> Passwords not match
age: true -> null
birthday: true -> null
roles: false -> All elements must satisfy the condition
````