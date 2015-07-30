package com.twu.biblioteca.staff;

import com.twu.biblioteca.entity.Shelf;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.assertTrue;

public class BorrowerTest
{
    @Test
    public void should_borrow_when_called()
    {
        //given
        String bookName = "awesome";
        Shelf shelf = mock(Shelf.class);
        Borrower borrower = new Borrower(shelf);
        System.setIn(new ByteArrayInputStream(bookName.getBytes()));

        //when
        boolean result = borrower.doService();

        //then
        assertTrue(result);
        verify(shelf, times(1)).borrowOutBook(bookName);
        System.setIn(System.in);
    }
}