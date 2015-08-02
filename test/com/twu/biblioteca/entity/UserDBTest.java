package com.twu.biblioteca.entity;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class UserDBTest
{
    private UserDB userDB;

    @BeforeMethod
    public void setUp()
    {
        userDB = new UserDB();
    }

    @Test
    public void should_pass_when_input_valid_account_and_password()
    {
        //given
        String validAccount = "123-4567";
        String validPassword = "password";

        //when
        boolean result = userDB.validateAccount(validAccount, validPassword);

        //then
        assertTrue(result);
    }

    @Test
    public void should_not_pass_when_input_invalid_account_and_password()
    {
        //given
        String invalidAccount = "awe";
        String invalidPassword = "some";

        //when
        boolean result = userDB.validateAccount(invalidAccount, invalidPassword);

        //then
        assertFalse(result);
    }

    @Test
    public void should_return_user_when_input_valid_user_account()
    {
        //given
        String validUserAccount = "123-4567";
        String expectedName = "Alice";
        String expectedEmail = "alice@gmail.com";
        String expectedPhone = "012-8888";

        //when
        User result = userDB.findUserByAccount(validUserAccount);

        //then
        assertEquals(result.getName(), expectedName);
        assertEquals(result.getEmail(), expectedEmail);
        assertEquals(result.getPhone(), expectedPhone);
    }
}