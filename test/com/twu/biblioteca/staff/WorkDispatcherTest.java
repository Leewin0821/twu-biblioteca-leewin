package com.twu.biblioteca.staff;

import static com.twu.biblioteca.staff.WorkDispatcher.*;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

import com.twu.biblioteca.entity.UserDB;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.twu.biblioteca.entity.Shelf;

public class WorkDispatcherTest
{
    private WorkDispatcher workDispatcher;

    @Mock
    private Shelf shelf;

    @BeforeMethod
    public void setUp() throws Exception
    {
        initMocks(this);
        Staff bookLister = new BookLister(shelf);
        Staff quiter = new Quiter();
        Staff emptyStaff = new EmptyStaff();
        Staff borrower = new BookBorrower(shelf);
        Staff returner = new Returner(shelf);
        Staff movieLister = new MovieLister(shelf);
        Staff movieBorrower = new MovieBorrower(shelf);
        UserDB userDB = new UserDB();
        Staff userNotifier = new UserNotifier(userDB);
        workDispatcher = new WorkDispatcher(
                bookLister, quiter, emptyStaff, borrower, returner, movieLister, movieBorrower, userNotifier
        );
    }

    @Test
    public void should_return_deliverer_when_input_list_book()
    {
        //when
        Staff result = workDispatcher.dispatchTask(LIST_BOOK_COMMAND);

        //then
        assertThat(result, instanceOf(BookLister.class));
    }

    @Test
    public void should_return_quiter_when_input_quit()
    {
        //when
        Staff result = workDispatcher.dispatchTask(QUIT_COMMAND);

        //then
        assertThat(result, instanceOf(Quiter.class));
    }

    @Test
    public void should_return_empty_staff_when_input_invalid()
    {
        //given
        String invalid_command = "abc";

        //when
        Staff result = workDispatcher.dispatchTask(invalid_command);

        //then
        assertThat(result, instanceOf(EmptyStaff.class));
    }

    @Test
    public void should_return_book_borrower_when_input_checkout_book()
    {
        //when
        Staff result = workDispatcher.dispatchTask(BORROW_BOOK_COMMAND);

        //then
        assertThat(result, instanceOf(BookBorrower.class));
    }

    @Test
    public void should_return_returner_when_input_return()
    {
        //when
        Staff result = workDispatcher.dispatchTask(RETURN_COMMAND);

        //then
        assertThat(result, instanceOf(Returner.class));

    }

    @Test
    public void should_return_movieLister_when_input_list_movie()
    {
        //when
        Staff result = workDispatcher.dispatchTask(LIST_MOVIE_COMMAND);

        //then
        assertThat(result, instanceOf(MovieLister.class));
    }

    @Test
    public void should_return_movie_borrower_when_input_checkout_movie()
    {
        //when
        Staff result = workDispatcher.dispatchTask(BORROW_MOVIE_COMMAND);

        //then
        assertThat(result, instanceOf(MovieBorrower.class));
    }

    @Test
    public void should_return_user_notifier_when_input_user_information()
    {
        //when
        Staff result = workDispatcher.dispatchTask(USER_INFORMATION_COMMAND);

        //then
        assertThat(result, instanceOf(UserNotifier.class));
    }
}