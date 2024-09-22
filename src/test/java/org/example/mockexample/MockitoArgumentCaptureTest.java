package org.example.mockexample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MockitoArgumentCaptureTest {
    /**
     * Аннотация @Captor используется для создания объекта ArgumentCaptor.
       ArgumentCaptor позволяет перехватывать аргументы, которые передаются
       в вызовы методов во время выполнения теста, чтобы затем их проверить.
     */
    @Captor
    private ArgumentCaptor<List<String>> captor;

    @Test
    public final void shouldContainCertainListItem(@Mock List<String> mockedList){

        // Создаем список и добавляем элементы
        var asList = Arrays.asList("someElement_test", "someElement");
        mockedList.addAll(asList);

        // Проверяем, что метод addAll был вызван у мок-объекта
        verify(mockedList).addAll(captor.capture());

        // Получаем аргумент, который был передан в метод addAll
        List<String> capturedArgument = captor.getValue();

        // Проверяем, что захваченный аргумент содержит элемент "someElement"
        assertThat(capturedArgument, hasItem("someElement_test"));
    }
}
