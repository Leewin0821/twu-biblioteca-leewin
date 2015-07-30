package com.twu.biblioteca.staff;

import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class EmptyStaffTest
{
    @Test
    public void should_return_warning_message_when_call_service()
    {
        //given
        String expectedMessage = "Select a valid option!\n";
        EmptyStaff emptyStaff = new EmptyStaff();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        //when
        boolean result = emptyStaff.doService();

        //then
        assertTrue(result);
        assertEquals(expectedMessage, outContent.toString());
        System.setOut(null);
    }
}