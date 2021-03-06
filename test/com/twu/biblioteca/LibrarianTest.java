package com.twu.biblioteca;

import com.twu.biblioteca.staff.Staff;
import com.twu.biblioteca.staff.WorkDispatcher;
import org.junit.Ignore;
import org.mockito.Mock;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static com.twu.biblioteca.staff.WorkDispatcher.*;
import static com.twu.biblioteca.staff.WorkDispatcher.LIST_BOOK_COMMAND;
import static com.twu.biblioteca.staff.WorkDispatcher.QUIT_COMMAND;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class LibrarianTest
{
    private Librarian librarian;

    @Mock
    private Staff messenger;

    @Mock
    private Staff bookLister;

    @Mock
    private Staff quiter;

    @Mock
    private Staff emptyStaff;

    @Mock
    private Staff borrower;

    @Mock
    private Staff returner;

    @Mock
    private Staff movierLister;

    @Mock
    private Staff movieBorrower;

    @Mock
    private Staff guard;

    @Mock
    private Staff userNotifier;

    @BeforeMethod
    public void setUp()
    {
        initMocks(this);
        WorkDispatcher dispatcher = new WorkDispatcher(
                bookLister, quiter, emptyStaff, borrower, returner, movierLister, movieBorrower, userNotifier
        );
        librarian = new Librarian(messenger, guard, dispatcher);
    }

    @AfterMethod
    public void tearDown()
    {
        System.setIn(System.in);
    }

    @Test
    public void should_show_welcome_message_when_start_application()
    {
        //given
        prepareValidUserToLogin();
        InputStream inputStream = new ByteArrayInputStream(QUIT_COMMAND.getBytes());
        System.setIn(inputStream);

        //when
        librarian.work();

        //then
        verify(messenger, times(1)).doService();
    }

//    @Test
//    @Ignore
//    public void should_call_guard_service_when_start_application()
//    {
//        //given
//        InputStream inputStream = new ByteArrayInputStream("123-4567 password".getBytes());
//        System.setIn(inputStream);
//
//        //when
//        librarian.work();
//
//        //then
//        verify(guard, times(1)).doService();
//    }

    @Test
    public void should_list_books_when_user_input_list_book()
    {
        //given
        prepareValidUserToLogin();
        InputStream inputStream = new ByteArrayInputStream(LIST_BOOK_COMMAND.getBytes());
        System.setIn(inputStream);

        //when
        librarian.work();

        //then
        verify(bookLister, times(1)).doService();
    }

    @Test
    public void should_show_invalid_option_message_when_input_wrong_command()
    {
        //given
        prepareValidUserToLogin();
        String invalid_command = "abc";
        InputStream inputStream = new ByteArrayInputStream(invalid_command.getBytes());
        System.setIn(inputStream);

        //when
        librarian.work();

        //then
        verify(emptyStaff, times(1)).doService();
    }

    @Test
    public void should_borrow_book_when_input_checkout()
    {
        //given
        prepareValidUserToLogin();
        InputStream inputStream = new ByteArrayInputStream(BORROW_BOOK_COMMAND.getBytes());
        System.setIn(inputStream);

        //when
        librarian.work();

        //then
        verify(borrower, times(1)).doService();
    }

    @Test
    public void should_return_book_when_input_return()
    {
        //given
        prepareValidUserToLogin();
        InputStream inputStream = new ByteArrayInputStream(RETURN_COMMAND.getBytes());
        System.setIn(inputStream);

        //when
        librarian.work();

        //then
        verify(returner, times(1)).doService();
    }

    @Test
    public void should_list_movie_when_input_list_movie()
    {
        //given
        prepareValidUserToLogin();
        InputStream inputStream = new ByteArrayInputStream(LIST_MOVIE_COMMAND.getBytes());
        System.setIn(inputStream);

        //when
        librarian.work();

        //then
        verify(movierLister, times(1)).doService();
    }

    @Test
    public void should_display_user_information_when_input_user_information()
    {
        //given
        prepareValidUserToLogin();
        InputStream inputStream = new ByteArrayInputStream(USER_INFORMATION_COMMAND.getBytes());
        System.setIn(inputStream);

        //when
        librarian.work();

        //then
        verify(userNotifier, times(1)).doService();
    }

    private void prepareValidUserToLogin()
    {
        given(guard.doService()).willReturn(true);
    }
}
