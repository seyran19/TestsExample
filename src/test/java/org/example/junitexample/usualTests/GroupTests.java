package org.example.junitexample.usualTests;

import org.example.junitexample.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupTests {

    private static User user;

    @BeforeAll
    public static void setUp() {
        user = new User();
        user.setAge("5");
        user.setName("John");
    }

    @Test
    void testGroup(){
        assertAll("user Information's",
                () -> assertEquals(5, user.getAge(), "age must be right"),
                () -> assertEquals("John", user.getName(), "name must be right")
        );
    }
}
