package com.twu.biblioteca.staff;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class MessengerTest
{
    @Test
    public void should_return_true_when_call_service()
    {
        //given
        Messenger messenger = new Messenger();

        //when
        boolean result = messenger.doService();

        //then
        assertTrue(result);
    }
}