package org.example.junitexample.usualTests;

import org.example.junitexample.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserExceptionTests {

    private static User user;

    @BeforeAll
    public static void setUp() {
        user = new User();
    }

    @Test
    void testException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> user.setAge("we"), "where is exception?");
        assertEquals("Age must be an Integer.", exception.getMessage());
    }
}
