package org.example.junitexample.parameterizedTests;

import org.example.junitexample.Calculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Для этого примера мы используем @MethodSource аннотацию.
 * Мы даем ему имя функции(й), которую мы хотим вызвать для получения тестовых данных.
 * Функция должна быть статической и возвращать либо коллекцию, либо итератор, либо поток, либо массив.
 * При выполнении тестовый метод вызывается один раз для каждой записи в источнике данных.
 */
public class UsingParameterizedTest {

    public static int[][] data() {
        return new int[][]{{1, 2, 2}, {5, 3, 15}, {121, 4, 484}
        };
    }

    @ParameterizedTest
    @MethodSource(value = "data")
    void testWithStringParameter(int[] data) {
        Calculator calculator = new Calculator();
        int m1 = data[0];
        int m2 = data[1];
        int expected = data[2];
        assertEquals(expected, calculator.multiply(m1, m2));
    }
}
