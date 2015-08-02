package com.twu.biblioteca.staff;

import com.google.inject.Inject;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.entity.UserDB;

public class UserNotifier implements Staff
{
    private UserDB userDB;

    @Inject
    public UserNotifier(UserDB userDB)
    {
        this.userDB = userDB;
    }

    public boolean doService()
    {
        User user = userDB.findUserByAccount(userDB.currentAccount);
        System.out.println(user.toString());
        return true;
    }
}
