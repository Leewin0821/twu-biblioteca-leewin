package com.twu.biblioteca.staff;

import com.twu.biblioteca.entity.Shelf;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.assertTrue;

public class BookBorrowerTest
{
    @Test
    public void should_borrow_book_when_called()
    {
        //given
        String bookName = "awesome";
        Shelf shelf = mock(Shelf.class);
        BookBorrower bookBorrower = new BookBorrower(shelf);
        System.setIn(new ByteArrayInputStream(bookName.getBytes()));

        //when
        boolean result = bookBorrower.doService();

        //then
        assertTrue(result);
        verify(shelf, times(1)).borrowOutBook(bookName);
        System.setIn(System.in);
    }
}