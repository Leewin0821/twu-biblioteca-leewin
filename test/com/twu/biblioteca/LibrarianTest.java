package com.twu.biblioteca;

import com.twu.biblioteca.staff.Deliverer;
import com.twu.biblioteca.staff.Messenger;
import com.twu.biblioteca.staff.Staff;
import com.twu.biblioteca.staff.WorkDispatcher;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static com.twu.biblioteca.staff.WorkDispatcher.LIST_BOOK;
import static com.twu.biblioteca.staff.WorkDispatcher.QUIT;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class LibrarianTest
{
    private Librarian librarian;

    private WorkDispatcher dispatcher;

    @Mock
    private Messenger messenger;

    @Mock
    private Deliverer deliverer;

    @Mock
    private Staff quiter;

    @BeforeMethod
    public void setUp()
    {
        initMocks(this);
        dispatcher = new WorkDispatcher(deliverer, quiter);
        librarian = new Librarian(messenger, dispatcher);
    }

    @Test
    public void should_show_welcome_message_when_start_application()
    {
        //given
        String[] args = new String[1];
        InputStream inputStream = new ByteArrayInputStream(QUIT.getBytes());
        System.setIn(inputStream);

        //when
        librarian.work();

        //then
        verify(messenger, times(1)).doService();
        System.setIn(System.in);
    }

    @Test
    public void should_list_books_when_user_input_list()
    {
        //given
        String[] args = new String[1];
        InputStream inputStream = new ByteArrayInputStream(LIST_BOOK.getBytes());
        System.setIn(inputStream);

        //when
        librarian.work();

        //then
        verify(deliverer, times(1)).doService();
        System.setIn(System.in);
    }
}