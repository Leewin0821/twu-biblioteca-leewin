package com.twu.biblioteca;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.twu.biblioteca.helper.Messenger;

public class LibrarianTest
{
    private Librarian librarian;

    @Mock
    private Messenger messenger;

    @BeforeMethod
    public void setUp() throws Exception
    {
        initMocks(this);
        librarian = new Librarian(messenger);
    }

    @Test
    public void should_show_welcome_message_when_application_starts()
    {
        //given
        InputStream inputStream = new ByteArrayInputStream("2".getBytes());

        //when
        System.setIn(inputStream);
        librarian.manage();

        //then
        verify(messenger, times(1)).displayWelcomeMessage();
        System.setIn(System.in);
    }

}