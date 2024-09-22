package org.example.mockexample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockitoVerifyTest {

    @Test
    public void testVerify(@Mock Database database)  {
        // create and configure mock
        when(database.getUniqueId()).thenReturn(43);


        // call method testing on the mock with parameter 12
        database.setUniqueId(12);
        database.getUniqueId();
        database.getUniqueId();


        // now check if method testing was called with the parameter 12
        verify(database).setUniqueId(ArgumentMatchers.eq(12));

        // was the method called twice?
        verify(database, times(2)).getUniqueId();

        // other alternatives for verifiying the number of method calls for a method
        verify(database, never()).isAvailable();
        verify(database, never()).setUniqueId(13);
        verify(database, atLeastOnce()).setUniqueId(12); // по крайне мере 1 раз
        verify(database, atLeast(2)).getUniqueId(); // по крайней мере 2 раза

        // more options are
        // times(numberOfTimes)
        // atMost(numberOfTimes) // не более
        // This let's you check that no other methods where called on this object.
        // You call it after you have verified the expected method calls.
        /**
         * Этот метод проверяет, что никаких других методов не были вызваны на объекте database,
           кроме тех, которые были уже проверены с помощью verify.
         */
        verifyNoMoreInteractions(database);
    }
}
