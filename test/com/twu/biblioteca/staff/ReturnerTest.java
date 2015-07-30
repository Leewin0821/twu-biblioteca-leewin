package com.twu.biblioteca.staff;

import com.twu.biblioteca.entity.Shelf;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.testng.AssertJUnit.assertTrue;

public class ReturnerTest
{
    @Test
    public void should_return_when_called()
    {
        //given
        String bookName = "awesome";
        Shelf shelf = mock(Shelf.class);
        Returner returner = new Returner(shelf);
        System.setIn(new ByteArrayInputStream(bookName.getBytes()));

        //when
        boolean result = returner.doService();

        //then
        assertTrue(result);
        verify(shelf, times(1)).returnBook(bookName);
        System.setIn(System.in);
    }
}