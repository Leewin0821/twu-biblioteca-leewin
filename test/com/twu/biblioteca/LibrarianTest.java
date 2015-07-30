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

import static com.twu.biblioteca.staff.WorkDispatcher.*;
import static com.twu.biblioteca.staff.WorkDispatcher.LIST_BOOK_COMMAND;
import static com.twu.biblioteca.staff.WorkDispatcher.QUIT_COMMAND;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class LibrarianTest
{
    private Librarian librarian;

    @Mock
    private Messenger messenger;

    @Mock
    private Deliverer deliverer;

    @Mock
    private Staff quiter;

    @Mock
    private Staff emptyStaff;

    @Mock
    private Staff borrower;

    @Mock
    private Staff returner;

    @BeforeMethod
    public void setUp()
    {
        initMocks(this);
        WorkDispatcher dispatcher = new WorkDispatcher(deliverer, quiter, emptyStaff, borrower, returner);
        librarian = new Librarian(messenger, dispatcher);
    }

    @Test
    public void should_show_welcome_message_when_start_application()
    {
        //given
        String[] args = new String[1];
        InputStream inputStream = new ByteArrayInputStream(QUIT_COMMAND.getBytes());
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
        InputStream inputStream = new ByteArrayInputStream(LIST_BOOK_COMMAND.getBytes());
        System.setIn(inputStream);

        //when
        librarian.work();

        //then
        verify(deliverer, times(1)).doService();
        System.setIn(System.in);
    }

    @Test
    public void should_show_invalid_option_message_when_input_wrong_command()
    {
        //given
        String[] args = new String[1];
        String invalid_command = "abc";
        InputStream inputStream = new ByteArrayInputStream(invalid_command.getBytes());
        System.setIn(inputStream);

        //when
        librarian.work();

        //then
        verify(emptyStaff, times(1)).doService();
        System.setIn(System.in);
    }

    @Test
    public void shoud_borrow_book_when_input_checkout()
    {
        //given
        String[] args = new String[1];
        InputStream inputStream = new ByteArrayInputStream(BORROW_COMMAND.getBytes());
        System.setIn(inputStream);

        //when
        librarian.work();

        //then
        verify(borrower, times(1)).doService();
        System.setIn(System.in);
    }

    @Test
    public void shoud_return_book_when_input_return()
    {
        //given
        String[] args = new String[1];
        InputStream inputStream = new ByteArrayInputStream(RETURN_COMMAND.getBytes());
        System.setIn(inputStream);

        //when
        librarian.work();

        //then
        verify(returner, times(1)).doService();
        System.setIn(System.in);
    }
}
