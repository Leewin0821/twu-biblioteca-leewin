package com.twu.biblioteca.staff;

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
        workDispatcher = new WorkDispatcher(deliverer, quiter, emptyStaff);
    }

    @Test
    public void should_return_deliverer_when_input_list()
    {
        //given
        String input_command = "list";

        //when
        Staff result = workDispatcher.dispatchTask(input_command);

        //then
        assertThat(result, instanceOf(Deliverer.class));
    }

    @Test
    public void should_return_quiter_when_input_quit()
    {
        //given
        String input_command = "quit";

        //when
        Staff result = workDispatcher.dispatchTask(input_command);

        //then
        assertThat(result, instanceOf(Quiter.class));
    }

    @Test
    public void should_return_empty_staff_when_input_invalid()
    {
        //given
        String input_command = "abc";

        //when
        Staff result = workDispatcher.dispatchTask(input_command);

        //then
        assertThat(result, instanceOf(EmptyStaff.class));

    }
}