package com.qacart.todo.utils;

import com.github.javafaker.Faker;
import com.qacart.todo.objects.User;

/**
 * UserUtils class provides utility methods for generating random User objects.
 * It uses the Faker library to create realistic random data for testing purposes.
 */
public class UserUtils {

    private static final Faker faker = new Faker();

    /**
     * Generates a random User object with a first name, last name, email, and password.
     *
     * @return a User object populated with random data.
     */
    public User generateRandomUser() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.regexify("[a-zA-Z0-9]{10,12}"); // Password between 10 to 12 characters

        return new User(firstName, lastName, email, password);
    }
}
