package org.example.mockexample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Сообщает Mockito о необходимости создания макетов
   на основе аннотации @Mock. Для этого требуется JUnit 5.
   Если у вас другая версия JUnit, вызовите Mock.init()метод настройки.
 * Сообщает Mockito о необходимости создания имитации экземпляра базы данных.
 * Настройте Mock так, чтобы он возвращал значение true при вызове его метода isAvailable.
   Дополнительные параметры см. Далее.
 * Выполняет некоторый код тестируемого класса
 * Утверждает, что вызов метода вернул значение true
 */
@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    Database databaseMock;

    @Test
    public void testQuery() {
        assertNotNull(databaseMock);
        when(databaseMock.isAvailable()).thenReturn(true);
        Service t  = new Service(databaseMock);
        boolean check = t.query("* from t");
        assertTrue(check);
    }
}
