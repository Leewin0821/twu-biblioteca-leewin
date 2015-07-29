package com.twu.biblioteca;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ManagerTest
{
    private Manager manager;

    @Mock
    private Librarian librarian;

    @BeforeMethod
    public void setUp() throws Exception
    {
        initMocks(this);
        manager = new Manager(librarian);
    }

    @Test
    public void should_show_welcome_message_when_start_application()
    {
        //given
        String[] args = new String[1];
        InputStream inputStream = new ByteArrayInputStream("2".getBytes());
        System.setIn(inputStream);

        //when
        manager.manage();

        //then
        verify(librarian, times(1)).showWelcomeMessage();
        System.setIn(System.in);
    }
}