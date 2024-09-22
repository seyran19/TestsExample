package org.example.junitexample;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

    public int multiply(int a, int b) {
        return a * b;
    }
}
