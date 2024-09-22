package org.example.junitexample.usualTests;

import org.example.junitexample.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTests {
    /**
     Метод, помеченный @BeforeEach, запускается перед каждым тестом.
     Метод, помеченный @BeforeAll, запускается один раз перед всеми тестами.
     Метод, аннотированный @Test, определяет тестовый метод.
     @DisplayName можно использовать для определения имени теста, которое будет отображаться пользователю.
     assertEquals это оператор утверждения, который проверяет, что ожидаемое и фактическое значение совпадают.
     Если нет, то отображается сообщение в конце метода.
     @RepeatedTest определяет, что этот тестовый метод будет выполнен несколько раз, в этом примере 5 раз.

     */

    private static Calculator calculator;

    @BeforeAll
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Simple multiplication should work")
    void testSimpleMultiplication() {
        assertEquals(20, calculator.multiply(2, 10), "Обычное умножение должно сработать");
    }

    @RepeatedTest(5)
    @DisplayName("Ensure correct handling of zero")
    void testMultiplyWithZero(){
        assertEquals(0, calculator.multiply(0, 1), "Кратное нулю должно быть равно нулю");
        assertEquals(0, calculator.multiply(5, 0), "Кратное нулю должно быть равно нулю");
    }


}
