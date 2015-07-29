package com.twu.biblioteca;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Ignore;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.twu.biblioteca.staff.Deliverer;
import com.twu.biblioteca.staff.Messenger;

public class LibrarianTest
{
    private Librarian librarian;

    @Mock
    private Messenger messenger;

    @Mock
    private Deliverer deliverer;

    @BeforeMethod
    public void setUp()
    {
        initMocks(this);
        librarian = new Librarian(messenger);
    }

    @Test
    public void should_show_welcome_message_when_start_application()
    {
        //given
        String[] args = new String[1];
        InputStream inputStream = new ByteArrayInputStream("2".getBytes());
        System.setIn(inputStream);

        //when
        librarian.work();

        //then
        verify(messenger, times(1)).doService();
        System.setIn(System.in);
    }

    @Test
    @Ignore
    public void should_list_books_when_user_input_list()
    {
        //given
        String[] args = new String[1];
        InputStream inputStream = new ByteArrayInputStream("list".getBytes());
        System.setIn(inputStream);

        //when
        librarian.work();

        //then
        verify(deliverer, times(1)).doService();
        System.setIn(System.in);
    }
}