package org.example.junitexample.dynamicTests;

import org.example.junitexample.Calculator;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

/**
 * Динамические методы тестирования аннотируются @TestFactoryи,
 * позволяют вам создавать несколько тестов типа DynamicTestс вашим кодом. Они могут возвращать:
 * <p>
 * Итерируемый
 * <p>
 * Коллекция
 * <p>
 * поток
 */
public class DynamicTestCreationTest {


    @TestFactory
    Stream<DynamicTest> testDifferentMultiplyOperations() {
        Calculator calculator = new Calculator();
        int[][] data = new int[][]{{1, 2, 2}, {5, 3, 15}, {121, 4, 484}};

        return Arrays.stream(data).map(entry -> {
            int m1 = entry[0];
            int m2 = entry[1];
            int expected = entry[2];

            return dynamicTest(m1 + " * " + m2 + " = " + expected, () -> {
                assertEquals(expected, calculator.multiply(m1, m2));
            });

        });
    }
}

