package com.junit_testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {

    UserRegistration registration = new UserRegistration();

    //Valid registration
    @Test
    void testValidUserRegistration() {
        assertTrue(registration.registerUser(
                "aditya", "aditya@gmail.com", "Pass123"
        ));
    }

    //Invalid username
    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () ->
                registration.registerUser("", "user@gmail.com", "Pass123")
        );
    }

    //Invalid email
    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () ->
                registration.registerUser("user", "usergmail.com", "Pass123")
        );
    }

    //Invalid password
    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () ->
                registration.registerUser("user", "user@gmail.com", "123")
        );
    }

    //Null values
    @Test
    void testNullInputs() {
        assertThrows(IllegalArgumentException.class, () ->
                registration.registerUser(null, null, null)
        );
    }
}
