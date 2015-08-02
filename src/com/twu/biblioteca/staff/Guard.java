package com.twu.biblioteca.staff;

import com.google.inject.Inject;
import com.twu.biblioteca.entity.UserDB;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Guard implements Staff
{
    private UserDB userDB;

    @Inject
    public Guard(UserDB userDB)
    {
        this.userDB = userDB;
    }

    public boolean doService()
    {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] strings = StringUtils.split(input, " ");
        if (strings.length != 2) {
            return false;
        }
        String account = strings[0];
        String password = strings[1];
        return userDB.validateAccount(account, password);
    }
}
