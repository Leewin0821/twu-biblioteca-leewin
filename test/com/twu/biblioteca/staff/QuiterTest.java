package com.twu.biblioteca.staff;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertFalse;

public class QuiterTest
{
    @Test
    public void should_return_false_when_call_do_service()
    {
        //given
        Quiter quiter = new Quiter();

        //when
        boolean result = quiter.doService();

        //given
        assertFalse(result);
    }
}