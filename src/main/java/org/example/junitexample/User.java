package org.example.junitexample;

import org.springframework.stereotype.Component;

@Component
public class User {

    int age;
    String name;

    public int getAge() {
        return age;
    }

    public void setAge(String ageString) {
        try {
            this.age = Integer.parseInt(ageString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Age must be an Integer.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
