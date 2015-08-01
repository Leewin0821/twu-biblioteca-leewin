package com.twu.biblioteca.entity;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.PrintStream;

import static org.testng.AssertJUnit.assertEquals;

public class ShelfTest
{
    private Shelf shelf;
    private ByteOutputStream outContent;

    @BeforeMethod
    public void setUp()
    {
        shelf = new Shelf();
        outContent = new ByteOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterMethod
    public void tearDown()
    {
        System.setOut(null);
    }

    @Test
    public void should_print_correct_message_when_borrow_with_valid_name()
    {
        //given
        String bookName = "Book One";
        String expectedMessage = "Thank you! Enjoy the book.\n";

        //when
        shelf.borrowOutBook(bookName);

        //then
        assertEquals(expectedMessage, outContent.toString());
    }

    @Test
    public void should_print_warning_message_when_borrow_with_invalid_name()
    {
        //given
        String bookName = "abc";
        String expectedMessage = "That book is not available.\n";

        //when
        shelf.borrowOutBook(bookName);

        //then
        assertEquals(expectedMessage, outContent.toString());
    }

    @Test
    public void should_print_correct_message_when_return_with_valid_name()
    {
        //given
        String bookName = "Book One";
        String expectedMessage = "Thank you for returning the book.\n";

        //when
        shelf.borrowOutBook(bookName);
        outContent = new ByteOutputStream();
        System.setOut(new PrintStream(outContent));
        shelf.returnBook(bookName);

        //then
        assertEquals(expectedMessage, outContent.toString());
    }

    @Test
    public void should_print_warning_message_when_return_with_invalid_name()
    {
        //given
        String bookName = "abc";
        String expectedMessage = "That is not a valid book to return.\n";

        //when
        shelf.returnBook(bookName);

        //then
        assertEquals(expectedMessage, outContent.toString());
    }

    @Test
    public void should_print_correct_message_when_borrow_movie_with_valid_name()
    {
        //given
        String movieName = "Movie One";
        String expectedMessage = "Thank you! Enjoy the movie.\n";

        //when
        shelf.borrowOutMovie(movieName);

        //then
        assertEquals(expectedMessage, outContent.toString());
    }

    @Test
    public void should_print_warning_message_when_borrow_movie_with_invalid_name()
    {
        //given
        String movieName = "abc";
        String expectedMessage = "That movie is not available.\n";

        //when
        shelf.borrowOutMovie(movieName);

        //then
        assertEquals(expectedMessage, outContent.toString());
    }

    @Test
    public void should_print_correct_message_when_return_movie_with_valid_name()
    {
        //given
        String movieName = "Movie One";
        String expectedMessage = "Thank you for returning the movie.\n";

        //when
        shelf.borrowOutMovie(movieName);
        outContent = new ByteOutputStream();
        System.setOut(new PrintStream(outContent));
        shelf.returnMovie(movieName);

        //then
        assertEquals(expectedMessage, outContent.toString());
    }

    @Test
    public void should_print_warning_message_when_return_movie_with_invalid_name()
    {
        //given
        String movieName = "abc";
        String expectedMessage = "That is not a valid movie to return.\n";

        //when
        shelf.returnMovie(movieName);

        //then
        assertEquals(expectedMessage, outContent.toString());
    }
}