package org.example.mockexample;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * Вы также можете использовать такие методы, как anyString или,
   anyInt, чтобы определить, что в зависимости от типа входных данных
   должно быть возвращено определенное значение.
 */
public class MockitoThrowsTest {

    // demonstrates the configuration of a throws with Mockito
    // not a read test, just "testing" Mockito behavior
    @Test
    void testMockitoThrows() {
        Properties properties = Mockito.mock(Properties.class);

        when(properties.get(Mockito.anyString())).thenThrow(new IllegalArgumentException("Stuff"));

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> properties.get("A"));

        assertEquals("Stuff", exception.getMessage());
    }
}
