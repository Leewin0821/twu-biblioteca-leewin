package com.twu.biblioteca.staff;

import com.twu.biblioteca.entity.UserDB;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class GuardTest
{
    private Guard guard;

    @BeforeMethod
    public void setUp()
    {
        guard = new Guard(new UserDB());
    }

    @Test
    public void should_pass_when_input_correct_account_and_password()
    {
        //given
        String validAccountAndPassword = "123-4567 password";
        InputStream inputStream = new ByteArrayInputStream(validAccountAndPassword.getBytes());
        System.setIn(inputStream);

        //when
        boolean result = guard.doService();

        //then
        assertTrue(result);
    }

    @Test
    public void should_not_pass_when_input_incorrect_account_and_password()
    {
        //given
        String invalidAccountAndPassword = "abc 123";
        InputStream inputStream = new ByteArrayInputStream(invalidAccountAndPassword.getBytes());
        System.setIn(inputStream);

        //when
        boolean result = guard.doService();

        //then
        assertFalse(result);
    }

    @Test
    public void should_not_pass_when_input_incorrect_account()
    {
        //given
        String invalidAccountAndPassword = "abc password";
        InputStream inputStream = new ByteArrayInputStream(invalidAccountAndPassword.getBytes());
        System.setIn(inputStream);

        //when
        boolean result = guard.doService();

        //then
        assertFalse(result);
    }

    @Test
    public void should_not_pass_when_input_incorrect_password()
    {
        //given
        String invalidAccountAndPassword = "123-4567 wrong";
        InputStream inputStream = new ByteArrayInputStream(invalidAccountAndPassword.getBytes());
        System.setIn(inputStream);

        //when
        boolean result = guard.doService();

        //then
        assertFalse(result);
    }
}