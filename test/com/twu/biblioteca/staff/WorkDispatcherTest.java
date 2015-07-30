package com.twu.biblioteca.staff;

import static com.twu.biblioteca.staff.WorkDispatcher.*;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

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
        Staff deliverer = new Deliverer(shelf);
        Staff quiter = new Quiter();
        Staff emptyStaff = new EmptyStaff();
        Staff borrower = new Borrower(shelf);
        Staff returner = new Returner(shelf);
        workDispatcher = new WorkDispatcher(deliverer, quiter, emptyStaff, borrower, returner);
    }

    @Test
    public void should_return_deliverer_when_input_list()
    {
        //when
        Staff result = workDispatcher.dispatchTask(LIST_BOOK_COMMAND);

        //then
        assertThat(result, instanceOf(Deliverer.class));
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
    public void should_return_borrower_when_input_checkout()
    {
        //when
        Staff result = workDispatcher.dispatchTask(BORROW_COMMAND);

        //then
        assertThat(result, instanceOf(Borrower.class));
    }

    @Test
    public void should_return_returner_when_input_borrow()
    {
        //when
        Staff result = workDispatcher.dispatchTask(RETURN_COMMAND);

        //then
        assertThat(result, instanceOf(Returner.class));

    }
}