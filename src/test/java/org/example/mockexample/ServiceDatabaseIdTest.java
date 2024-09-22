package org.example.mockexample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

/**
 * when().thenReturn() и when().thenThrow()
 * Mocks могут возвращать различные значения в зависимости от аргументов,
   переданных в метод. when(...).thenReturn(...)
   Цепочка методов используется для указания возвращаемого значения для вызова метода
   с предопределенными параметрами.
 */
@ExtendWith(MockitoExtension.class)
public class ServiceDatabaseIdTest {

    @Mock
    Database databaseMock;
    @Mock
    Iterator<String> i;

    Comparable<String> c;

    @Test
    void ensureMockitoReturnsTheConfiguredValue(){
        when(databaseMock.getUniqueId()).thenReturn(1);
        Service service = new Service(databaseMock);
        assertEquals(service.toString(), "Using database with id: 1");
    }

    // demonstrates the return of multiple values
    @Test
    void testMoreThanOneReturnValue() {
        when(i.next()).thenReturn("Mockito").thenReturn("rocks").thenReturn("z");
        String result = i.next() + " " + i.next() + " " + i.next();
        // assert
        assertEquals("Mockito rocks z", result);
    }

    // this test demonstrates how to return values based on the input
    // and that @Mock can also be used for a method parameter
    @Test
    void testReturnValueDependentOnMethodParameter(@Mock Comparable<String> c)  {
        when(c.compareTo("Mockito")).thenReturn(1);
        when(c.compareTo("Eclipse")).thenReturn(2);
        //assert
        assertEquals(1, c.compareTo("Mockito"));
        assertEquals(2, c.compareTo("Eclipse"));
    }

    // return a value based on the type of the provide parameter
    @Test
    void testReturnValueInDependentOnMethodParameter2(@Mock Comparable<Integer> c )  {
        when(c.compareTo(isA(Integer.class))).thenReturn(0);
        //assert
        assertEquals(0, c.compareTo(Integer.valueOf(4)));
    }


}
